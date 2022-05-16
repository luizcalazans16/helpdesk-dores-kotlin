package com.unilasalle.helpdeskdores.security.model

data class FirebaseProperties(
    val sessionExpireInDays: Int,
    val databaseUrl: String,
    val enableStrictServerSession: Boolean,
    val enableCheckSessionRevoked: Boolean,
    val enableLogoutEverywhere: Boolean,
)
