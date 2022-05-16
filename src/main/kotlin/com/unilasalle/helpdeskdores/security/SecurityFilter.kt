package com.unilasalle.helpdeskdores.security

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import com.google.firebase.auth.FirebaseToken
import com.unilasalle.helpdeskdores.security.model.Credentials
import com.unilasalle.helpdeskdores.security.model.SecurityProperties
import com.unilasalle.helpdeskdores.security.model.UserAuthenticationRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import java.io.IOException
import javax.servlet.FilterChain
import javax.servlet.ServletException
import javax.servlet.http.Cookie
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


@Component
class SecurityFilter : OncePerRequestFilter() {

    @Autowired
    private lateinit var securityService: SecurityService

    @Autowired
    private lateinit var securityProperties: SecurityProperties

    @Throws(ServletException::class, IOException::class)
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        verifyToken(request)
        filterChain.doFilter(request, response)
    }

    private fun verifyToken(request: HttpServletRequest? = null) {
        var session: String? = null
        var firebaseToken: FirebaseToken? = null
        var type: Credentials.CredentialType? = null
        val strictServerSessionEnabled: Boolean = securityProperties.firebaseProps?.enableStrictServerSession ?: false
        val sessionCookie: Cookie = cookieUtils.getCookie("session")
        val token: String? = request?.let { securityService.getBearerToken(it) }
        logger.info(token)

        try {
            session = sessionCookie.value;
            firebaseToken = FirebaseAuth.getInstance().verifySessionCookie(
                session,
                securityProperties.firebaseProps?.enableCheckSessionRevoked ?: false
            );
            type = Credentials.CredentialType.SESSION;
        } catch (ex: FirebaseAuthException) {
            ex.printStackTrace()
            logger.error("Firebase exception: " + ex.localizedMessage)
        }
    }

    private fun firebaseTokenUsertoDto(decodedToken: FirebaseToken): UserAuthenticationRequest {
        return UserAuthenticationRequest(
            uid = decodedToken.uid,
            name = decodedToken.name,
            email = decodedToken.email,
            isEmailVerified = decodedToken.isEmailVerified,
            issuer = decodedToken.issuer,
            picture = decodedToken.picture
        )
    }

}
}