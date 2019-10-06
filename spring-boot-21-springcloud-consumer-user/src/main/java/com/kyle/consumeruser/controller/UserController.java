package com.kyle.consumeruser.controller;

/**
 * @author: Kyle
 * @date: 2019/10/5 -  23:57
 */
@RestController
public class UserController {


    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/buy")
    public String buyTicket(String name){
      String s = restTemplate.getForobject("http://PROVIDER-TICKET/ticket",String.class);
        return name+"购买了"+s;
    }
}
