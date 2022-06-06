package com.unilasalle.helpdeskdores.thirdparty

import com.unilasalle.helpdeskdores.thirdparty.common.AbstractRepository
import com.unilasalle.helpdeskdores.thirdparty.model.LoginRequest
import com.unilasalle.helpdeskdores.thirdparty.model.TokenResponse
import org.springframework.http.HttpMethod
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class LoginService(
    private val restTemplate: RestTemplate
) : AbstractRepository() {

    companion object {
        private const val LOGIN_URL =
            "https://identitytoolkit.googleapis.com/v1/accounts:signInWithPassword?key=AIzaSyDU8YgJwOEQoGPTcgSn_4v4vO9r3nQvCfY"
    }

    fun sendLoginRequest(loginRequest: LoginRequest): String {
        val tokenRequest = newRequest(LOGIN_URL, HttpMethod.POST, createHeaders()).build()
        val tokenResponse = restTemplate.exchange(tokenRequest, TokenResponse::class.java)

        return tokenResponse.body!!.idToken
    }
}
