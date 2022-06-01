package com.unilasalle.helpdeskdores.business.service

import com.unilasalle.helpdeskdores.business.db.FirebaseInitializer
import com.unilasalle.helpdeskdores.business.model.Ticket
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TicketService {

    companion object {
        private const val TICKET_COLLECTION_NAME = "ticket"
    }

    @Autowired
    private lateinit var firebaseInitializer: FirebaseInitializer
    fun registerTicket(ticket: Ticket): Ticket {
        val firebaseDb = firebaseInitializer.getFirebase()
        ticket.id?.let { firebaseDb?.collection(TICKET_COLLECTION_NAME)?.document(it)?.set(ticket) }
    }
}