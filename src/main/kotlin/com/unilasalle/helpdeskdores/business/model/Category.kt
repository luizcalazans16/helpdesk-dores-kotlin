package com.unilasalle.helpdeskdores.business.model

import java.util.UUID


data class Category(

    val id: UUID,
    val name: String,
    val code: String
) {
}