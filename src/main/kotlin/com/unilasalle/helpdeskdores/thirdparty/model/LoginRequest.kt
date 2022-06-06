package com.unilasalle.helpdeskdores.thirdparty.model

data class LoginRequest(
    val email: String,
    val password: String,
    val returnSecureToken: Boolean
)