package com.unilasalle.helpdeskdores.business.model

import com.google.cloud.firestore.annotation.DocumentId
import java.util.UUID

data class Ticket(
    @DocumentId
    val id: String? = "HDT" + UUID.randomUUID().toString(),
    val title: String? = "",
    val description: String? = "",
    val priority: String? = "",
) {

    enum class TicketPriority {
        LOW,
        MEDIUM,
        HIGH,
        URGENT
    }
}