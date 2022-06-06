package com.unilasalle.helpdeskdores.webservice.controller

import com.unilasalle.helpdeskdores.thirdparty.LoginService
import com.unilasalle.helpdeskdores.thirdparty.model.LoginRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/login")
class LoginController {

    @Autowired
    private lateinit var loginService: LoginService

    @PostMapping
    fun login(@RequestBody loginRequest: LoginRequest) {
        loginService.sendLoginRequest(loginRequest)
    }
}