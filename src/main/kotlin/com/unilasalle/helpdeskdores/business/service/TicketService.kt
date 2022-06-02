package com.unilasalle.helpdeskdores.business.service

import com.unilasalle.helpdeskdores.business.model.Ticket
import com.unilasalle.helpdeskdores.business.repository.TicketRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class TicketService(
        private val ticketRepository: TicketRepository
) {
    fun findById(id: String): Ticket {
        return ticketRepository.findById(id) ?: throw Exception()
    }

    fun findByUserId(userId: UUID): Ticket {
        return ticketRepository.findByUserId(userId) ?: throw Exception()
    }

    fun registerTicket(ticket: Ticket): String {
        return ticketRepository.registerTicket(ticket)
    }

}