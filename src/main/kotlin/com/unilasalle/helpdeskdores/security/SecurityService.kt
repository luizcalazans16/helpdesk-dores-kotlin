package com.unilasalle.helpdeskdores.security

import com.unilasalle.helpdeskdores.security.model.Credentials
import com.unilasalle.helpdeskdores.security.model.SecurityProperties
import com.unilasalle.helpdeskdores.security.model.UserAuthenticationRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Service
import org.springframework.util.StringUtils
import org.springframework.web.context.support.ContextExposingHttpServletRequest
import javax.servlet.http.HttpServletRequest

@Service
class SecurityService {

    @Autowired
    private lateinit var httpServletRequest: ContextExposingHttpServletRequest

    @Autowired
    private lateinit var securityProperties: SecurityProperties


    fun getUser(): UserAuthenticationRequest {
        val userPrincipal: UserAuthenticationRequest
        val securityContext = SecurityContextHolder.getContext()
        securityContext?.authentication?.principal.let {
            it is UserAuthenticationRequest?
            userPrincipal = it as UserAuthenticationRequest
        }
        return userPrincipal
    }

    fun getCredentials(): Credentials {
        val securityContext = SecurityContextHolder.getContext()
        return securityContext.authentication.credentials as Credentials
    }

    fun isPublic(): Boolean {
        return securityProperties.allowedPublicApis?.contains(httpServletRequest.requestURI) ?: false
    }

    fun getBearerToken(request: HttpServletRequest): String? {
        var bearerToken: String? = null
        val authorization = request.getHeader("Authorization")
        if (StringUtils.hasText(authorization) && authorization.startsWith("Bearer ")) {
            bearerToken = authorization.substring(7);
        }
        return bearerToken;
    }
}