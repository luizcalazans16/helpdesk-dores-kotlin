package com.unilasalle.helpdeskdores.webservice.controller

import com.unilasalle.helpdeskdores.business.model.Ticket
import com.unilasalle.helpdeskdores.business.service.TicketService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/api/v1/tickets")
class TicketController {

    @Autowired
    private lateinit var ticketService: TicketService

    @GetMapping
    fun findById(@RequestParam id: String): Ticket? {
        return ticketService.findById(id)
    }

    @GetMapping("/user")
    fun findTicketByUserId(@RequestParam userId: UUID): Ticket? {
        return ticketService.findByUserId(userId)
    }

    @PostMapping
    fun createTicket(ticket: Ticket): String {
        return ticketService.registerTicket(ticket)
    }
}