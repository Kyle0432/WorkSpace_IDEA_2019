package com.kyle.task.controller;

import com.kyle.task.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Kyle
 * @date: 2019/10/3 -  23:00
 */
@RestController
public class AsyncController {

    @Autowired
    AsyncService asyncService;

    @GetMapping("/hello")
    public String hello(){
      asyncService.hello();
      return "success";
    }

}
