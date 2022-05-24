package com.unilasalle.helpdeskdores.business.model

import java.util.UUID

data class User(
    val id: String? = "",
    val email: String? = "",
    val name: String? = "",
    val password: String? = ""
)
