package com.kyle.cache;

import com.kyle.cache.bean.Employee;
import com.kyle.cache.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot12CacheApplicationTests {

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    StringRedisTemplate stringRedisTemplate; //操作k-v都是字符串的

    @Autowired
    RedisTemplate redisTemplate; //k-v都是对象的

    /**
     * Redis常见的五大数据类型
     * String(字符串)、List(列表)、Set(集合)、Hash(散列)、ZSet(有序集合)
     *
     * stringRedisTemplate.opsForValue()  [String(字符串)]
     * stringRedisTemplate.opsForList()   [List(列表)]
     * stringRedisTemplate.opsForSet()    [Set(集合)]
     * stringRedisTemplate.opsForHash()   [Hash(散列)]
     * stringRedisTemplate.opsForZSet()   [ZSet(有序集合)]
     */

    @Test
    public void test01(){
        //用字符串
        //给redis中保存数据也就是添加数据
        stringRedisTemplate.opsForValue().append("msg","hello");
        //从redis中获取数据
        String msg = stringRedisTemplate.opsForValue().get("msg");
        System.out.println(msg);
        //用列表
        //添加数据向列表的左边开始添加
        stringRedisTemplate.opsForList().leftPush("myList","1");
        stringRedisTemplate.opsForList().leftPush("myList","2");
    }
    //测试保存对象
    @Test
    public void test02(){
        Employee emp = employeeMapper.getEmpById(1);
        //默认如果保存对象,使用jdk序列化机制,序列化后的数据保存到redis中
        redisTemplate.opsForValue().set("emp-01",emp);
        //1.将数据以json的数据保存
          //自己将对象转换为json
          //redisTemplate默认的序列化规则;改变默认的序列化规则;

    }

    @Test
    public void contextLoads() {
    }

}
