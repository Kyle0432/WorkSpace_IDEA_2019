package com.kyle.cache.service;

import com.kyle.cache.bean.Department;
import com.kyle.cache.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author: Kyle
 * @date: 2019/9/28 -  23:53
 */
@Service
public class DeptService {
    @Autowired
    DepartmentMapper departmentMapper;

    /**
     * 缓存的数据能存入redis;
     * 第二次从缓存中查询就不能反序列化回来了
     * 原因就是存的是dept的json数据,cacheManager默认使用
     * @param id
     * @return
     */

    @Cacheable(cacheNames = "dept")
    public Department getDeptById(Integer id){
        System.out.println("查询部门:"+id);
        Department dept = departmentMapper.getDeptById(id);
        return dept;
    }
}
