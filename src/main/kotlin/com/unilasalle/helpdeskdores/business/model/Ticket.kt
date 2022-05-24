package com.unilasalle.helpdeskdores.business.model

import java.util.UUID

data class Ticket(

    val id: UUID,
    val title: String,
    val description: String,
    val priority: TicketPriority
) {

    enum class TicketPriority {
        LOW,
        MEDIUM,
        HIGH,
        URGENT
    }
}