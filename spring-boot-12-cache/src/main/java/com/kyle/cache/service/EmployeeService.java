package com.kyle.cache.service;

import com.kyle.cache.bean.Employee;
import com.kyle.cache.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

/**
 * @author: Kyle
 * @date: 2019/9/27 -  18:44
 */
//@CacheConfig这是一个公共注解,这里配置了,下面就不用配置多次了
//@CacheConfig(cacheNames = "emp")
@Service
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    /**
     * @Cacheable注解: 调用方法之前先看缓存里面有没有指定key要用的数据,如果没有就调方法,有的话直接用缓存
     * 将方法的运行结果进行缓存,以后再要相同的数据,我们就直接从缓存中获取,
     * 不再需要调用方法,也就是无需访问数据库了.
     *
     * CacheManager管理多个Cache组件的,对缓存的真正CRUD操作在Cache组件中,
     * 每个缓存组件都有自己唯一一个名字
     *
     * 几个属性:
     *     1.CacheNames/value 二选一: 指定缓存组件的名字;将方法的返回结果放在哪个缓存中,是数组的方式可以指定多个缓存
     *     2.key: 缓存数据使用key,可以用它来指定,不指定默认使用方法参数的值 比如参数值是1 那么键值对就是 1-方法的返回值
     *     key = "#id" 表示的是取出参数id的值作为key
     *         编写SpEL:#id,参数id的值  #a0  #p0  #root.args[0]
     *     3.keyGenerator: key的生成器;可以自己指定key的生成器的组件id
     *         key/keyGenerator:二选一
     *     4.cacheManager: 指定缓存管理器,或者是指定cacheResolver指定获取解析器都是一样的效果
     *         cacheManager/cacheResolver二选一
     *     5.condition: 指定符合条件的情况下才进行缓存  condition = "#id>0"
     *     6.unless: 否定缓存,当unless指定的条件为true,我们的方法返回值就不会被缓存 ,可以获取到结果进行判断
     *              unless = " #result == null"
     *              unless = "#a0==2":如果第一个参数的值是2,结果就不缓存
     *     7.sync: 是否使用异步模式
     * @param id
     * @return
     */
    @Cacheable(cacheNames = "emp",key = "#id",condition = "#id>0")
    public Employee getEmp(Integer id){
        System.out.println("查询"+id+"号员工");
        Employee emp = employeeMapper.getEmpById(id);
        return  emp;
    }


    /**
     * @CachePut注解:直接先调用方法,调完之后把方法的结果放进缓存中
     *即调用方法,又更新缓存数据,同步更新缓存
     * 修改了数据库的某个数据,同时更新缓存
     *运行时机:
     *   1.先调用目标方法
     *   2.将目标方法的结果缓存起来
     *测试步骤:
     *   1.查询1号员工,查到的结果会放到缓存中
     *        key: 1   value: lastName : 张三
     *   2.以后查询还是之前的结果
     *   3.更新1号员工;[lastName:zhangsan; gender:0]
     *        key: 传入的employee对象  value: 不指定就是默认参数也就是返回的employee对象
     *        将方法的返回值也放进缓存了,但是这里要注意,如果查询员工的key和更新员工的key不一样
     *        那么你在缓存中查询的结果还是之前的,而不是更新后的,所以只有查询的key和更新的key是
     *        一样的这样才能达到同步更新缓存,更新后的结果放入缓存,再次查询也就是更新后的值了
     *    4.查询1号员工?
     *        应该是更新后的员工;运行结果却不是
     *          key:"#employee.id":使用传入的参数的员工id 也就是和查询的key是一样的
     *          key:"result.id":使用返回后的id  result表示的是返回的结果,然后拿里面的id
     *        查询缓存为什么是没有更新前的数据?
     *           原因是1号员工没有在缓存中更新,两者的key不一样,所以查询的时候还是之前的缓存数据
     *           而更新的数据没有在查询的key中,所以无法同步更新缓存
     */
    @CachePut(value = "emp")
    public Employee updateEmp(Employee employee){
        System.out.println("updateEmp:"+employee);
        employeeMapper.updateEmp(employee);
        return employee;
    }

    /**
     * @CacheEvict注解:缓存清除
     * key:指定要清除的数据缓存
     * allEntries=true:清除所有的缓存数据
     * beforeInvocation=false:缓存的清除是否在方法之前执行
     *       默认代表是在方法执行之后执行
     *       这样如果这个方法中有异常,方法无法执行到最后
     *       缓存就无法有效清除了
     * beforeInvocation=true:缓存的清除是在方法运行前就执行,
     *       无论方法是否出现异常,缓存都清除
     */
    @CacheEvict(value = "emp",key = "#id")
    public void deleteEmp(Integer id){
        System.out.println("deleteEmp"+id);
        employeeMapper.deleteEmpById(id);
    }

    /**
     *@Caching注解:是@Cacheable、@CachePut、@CacheEvict的组合
     */

    @Caching(
            cacheable = {
                    @Cacheable(value = "emp",key = "#lastName")
            },
            put = {
                    @CachePut(value = "emp",key = "#result.id"),
                    @CachePut(value = "emp",key = "#result.email")
            }
    )
    public Employee getEmpByLastName(String lastName){
       return employeeMapper.getEmpByLastName(lastName);
    }
}
