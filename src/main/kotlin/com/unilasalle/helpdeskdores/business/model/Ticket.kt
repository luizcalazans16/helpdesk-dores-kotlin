package com.unilasalle.helpdeskdores.business.model

import java.util.UUID
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table
data class Ticket(
    @Id
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