package com.unilasalle.helpdeskdores.business.model

import com.google.cloud.firestore.annotation.DocumentId
import java.util.UUID

data class User(
    @DocumentId
    val id: String? = UUID.randomUUID().toString(),
    val email: String? = "",
    val name: String? = "",
    val password: String? = "",
)
