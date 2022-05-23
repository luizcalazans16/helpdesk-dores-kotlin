package com.unilasalle.helpdeskdores.webservice.controller

import com.unilasalle.helpdeskdores.business.model.User
import com.unilasalle.helpdeskdores.business.service.UserService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/users")
class UserController(
    private val userService: UserService
) {

    @GetMapping
    fun findById(@RequestParam id: String): User {
        return userService.findById(id)
    }

    @PostMapping
    fun registerUser(@RequestBody user: User): String {
        return userService.registerUser(user)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: String, @RequestBody user: User) {
        return userService.update(id, user)
    }
}