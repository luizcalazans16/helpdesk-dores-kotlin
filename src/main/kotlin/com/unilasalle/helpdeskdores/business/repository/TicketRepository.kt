package com.unilasalle.helpdeskdores.business.repository

import com.unilasalle.helpdeskdores.business.model.Ticket
import java.util.UUID
import org.springframework.data.repository.kotlin.CoroutineCrudRepository

interface TicketRepository : CoroutineCrudRepository<Ticket, UUID> {
}