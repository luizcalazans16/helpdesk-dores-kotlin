package com.unilasalle.helpdeskdores.security.model

import com.google.firebase.auth.FirebaseToken

data class Credentials(
    val type: CredentialType,
    val decodedToken: FirebaseToken,
    val idToken: String,
    val session: String
) {
    enum class CredentialType {
        ID_TOKEN,
        SESSION
    }
}