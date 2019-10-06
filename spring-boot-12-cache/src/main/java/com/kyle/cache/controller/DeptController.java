package com.kyle.cache.controller;

import com.kyle.cache.bean.Department;
import com.kyle.cache.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Kyle
 * @date: 2019/9/29 -  0:03
 */
@RestController
public class DeptController {

    @Autowired
    DeptService deptService;

    @GetMapping("/dept/{id}")
    public Department getDept(@PathVariable("id") Integer id){
      return deptService.getDeptById(id);
    }
}
