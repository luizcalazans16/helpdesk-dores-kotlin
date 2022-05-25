package com.unilasalle.helpdeskdores.webservice.controller

import com.unilasalle.helpdeskdores.business.model.User
import com.unilasalle.helpdeskdores.business.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/users")
class UserController {

    @Autowired
    private lateinit var userService: UserService

    @GetMapping
    fun findById(@RequestParam id: String): User? {
        return userService.findById(id)
    }

    @PostMapping
    fun registerUser(@RequestBody user: User): String {
        return userService.registerUser(user)
    }

    @PutMapping
    fun update(@RequestBody user: User): String {
        return userService.update(user)
    }
}