package com.unilasalle.helpdeskdores.webservice.controller

import com.unilasalle.helpdeskdores.business.model.Ticket
import com.unilasalle.helpdeskdores.business.service.TicketService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/tickets")
class TicketController {

    @Autowired
    private lateinit var ticketService: TicketService

//    @PostMapping
//    fun createTicket(): Ticket {
//        return ticketService.registerTicket()
//    }
}