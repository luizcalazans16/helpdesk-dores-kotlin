package com.unilasalle.helpdeskdores.webservice.controller

import com.google.firebase.auth.FirebaseAuth
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RestController

@RestController
class TokenController {

    @Autowired
    private lateinit var firebaseAuth: FirebaseAuth
}