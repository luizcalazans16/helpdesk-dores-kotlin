package com.unilasalle.helpdeskdores.security.model

data class SecurityProperties(
    var cookieProps: CookieProperties? = null,
    var firebaseProps: FirebaseProperties? = null,
    var allowCredentials: Boolean = false,
    var allowedOrigins: List<String>? = null,
    var allowedHeaders: List<String>? = null,
    var exposedHeaders: List<String>? = null,
    var allowedMethods: List<String>? = null,
    var allowedPublicApis: List<String>? = null
)
