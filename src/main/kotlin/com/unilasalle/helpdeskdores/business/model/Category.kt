package com.unilasalle.helpdeskdores.business.model

import java.util.UUID
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table
data class Category(
    @Id
    val id: UUID,
    val name: String,
    val code: String
) {
}