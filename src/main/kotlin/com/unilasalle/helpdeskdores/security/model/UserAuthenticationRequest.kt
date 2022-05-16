package com.unilasalle.helpdeskdores.security.model

data class UserAuthenticationRequest(
    val uid: String,
    val name: String,
    val email: String,
    val isEmailVerified: Boolean,
    val issuer: String,
    val picture: String,
)
