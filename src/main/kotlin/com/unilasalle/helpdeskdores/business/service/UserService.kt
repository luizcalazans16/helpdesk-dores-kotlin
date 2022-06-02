package com.unilasalle.helpdeskdores.business.service

import com.unilasalle.helpdeskdores.business.model.User
import com.unilasalle.helpdeskdores.business.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
        private val userRepository: UserRepository
) {

    fun findById(id: String): User? {
        return userRepository.findById(id)
    }

    fun findByEmail(email: String): User? {
        return userRepository.findByEmail(email)
    }

    fun registerUser(user: User): String {
        return userRepository.registerUser(user)
    }

    fun update(user: User): String {
        return userRepository.update(user)
    }

    fun delete(id: String): String {
        return userRepository.delete(id)
    }

    fun emailAvailable(value: String): Boolean {
        return userRepository.emailAvailable(value)
    }
}