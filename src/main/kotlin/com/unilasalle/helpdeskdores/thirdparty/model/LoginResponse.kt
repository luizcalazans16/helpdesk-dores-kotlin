package com.unilasalle.helpdeskdores.thirdparty.model

data class LoginResponse(
    val kind: String,
    val localId: String,
    val email: String,
    val displayName: String,
    val idToken: String,
    val registered: Boolean
)