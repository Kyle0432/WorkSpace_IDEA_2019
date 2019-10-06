package com.kyle.deploytools.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Kyle
 * @date: 2019/10/6 -  11:08
 */

@RestController
public class LiveDeployController {

    @GetMapping("/")
    public String getSuccess(){
        return "success";
    }
}
