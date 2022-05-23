package com.unilasalle.helpdeskdores.business.service

import com.unilasalle.helpdeskdores.business.model.Ticket
import com.unilasalle.helpdeskdores.business.repository.TicketRepository
import org.springframework.stereotype.Service

@Service
class TicketService(
    private val ticketService: TicketRepository,
) {

//    suspend fun registerTicket(): Ticket {
//        return Ticket()
//    }
}