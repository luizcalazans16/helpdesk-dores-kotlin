package com.unilasalle.helpdeskdores.business.service

import com.unilasalle.helpdeskdores.business.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository
) {
}