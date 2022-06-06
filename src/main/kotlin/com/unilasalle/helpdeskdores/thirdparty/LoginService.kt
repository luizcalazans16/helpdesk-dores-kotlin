package com.unilasalle.helpdeskdores.thirdparty

import com.unilasalle.helpdeskdores.thirdparty.common.AbstractRepository
import com.unilasalle.helpdeskdores.thirdparty.model.LoginRequest
import com.unilasalle.helpdeskdores.thirdparty.model.LoginResponse
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.http.HttpMethod
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate

@Component
class LoginService(
    @Qualifier("restTemplate") private val restTemplate: RestTemplate
) : AbstractRepository() {

    companion object {
        private const val LOGIN_URL =
            "https://identitytoolkit.googleapis.com/v1/accounts:signInWithPassword?key=AIzaSyDU8YgJwOEQoGPTcgSn_4v4vO9r3nQvCfY"
    }

    fun sendLoginRequest(loginRequest: LoginRequest): LoginResponse? {
        val tokenRequest = newRequest(LOGIN_URL, HttpMethod.POST, createHeaders())
            .body(loginRequest)
        return restTemplate.exchange(tokenRequest, LoginResponse::class.java).body

    }
}
