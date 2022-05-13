package com.unilasalle.helpdeskdores.business.model

import java.util.UUID
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table
data class User(
    @Id
    val id: UUID,
    val email: String,
    val name: String,
    val password: String
)
