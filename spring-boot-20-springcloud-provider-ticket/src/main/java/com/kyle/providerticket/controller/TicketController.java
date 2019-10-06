package com.kyle.providerticket.controller;

import com.kyle.providerticket.service.TicketService;

/**
 * @author: Kyle
 * @date: 2019/10/5 -  23:32
 */
@RestController
public class TicketController {


    @Autowired
    TicketService ticketService;

    @GetMapping("/ticket")
    public String getTicket(){
        return ticketService.getTicket();
    }

}
