package com.unilasalle.helpdeskdores.business.repository

import com.google.api.core.ApiFuture
import com.google.cloud.firestore.DocumentSnapshot
import com.unilasalle.helpdeskdores.business.db.FirebaseInitializer
import com.unilasalle.helpdeskdores.business.model.Ticket
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import java.io.File
import java.util.UUID

@Repository
class TicketRepository {
    companion object {
        private const val TICKET_COLLECTION_NAME = "ticket"
    }

    @Autowired
    private lateinit var firebaseInitializer: FirebaseInitializer

    fun findById(id: String): Ticket? {
        val firestoreDb = firebaseInitializer.getFirebase()
        val documentReference = firestoreDb?.collection(TICKET_COLLECTION_NAME)?.document(id)
        val documentSnapshot: ApiFuture<DocumentSnapshot> = documentReference?.get() as ApiFuture<DocumentSnapshot>
        val document: DocumentSnapshot = documentSnapshot.get()

        if (document.exists()) {
            return document.toObject(Ticket::class.java)
        } else {
            throw Exception()
        }
    }

    fun findByUserId(userId: UUID): Ticket? {
        val firebaseDb = firebaseInitializer.getFirebase()
        val documentReference = firebaseDb?.collection(TICKET_COLLECTION_NAME)?.document(userId.toString())
        val documentSnapshot = documentReference?.get() as ApiFuture<DocumentSnapshot>
        val document = documentSnapshot.get()

        if (document.exists()) {
            return document.toObject(Ticket::class.java)
        }
        return null
    }

    fun registerTicket(ticket: Ticket): String {
        val firebaseDb = firebaseInitializer.getFirebase()
        ticket.id?.let {
            firebaseDb?.collection(TICKET_COLLECTION_NAME)?.document(it)?.set(ticket)
        }
        return "Ticket aberto com sucesso"
    }
    private fun uploadFile(file: File, fileName: String) {

    }

}