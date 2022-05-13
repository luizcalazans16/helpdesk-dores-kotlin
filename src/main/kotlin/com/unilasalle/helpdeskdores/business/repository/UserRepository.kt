package com.unilasalle.helpdeskdores.business.repository

import com.unilasalle.helpdeskdores.business.model.User
import java.util.UUID
import org.springframework.data.repository.kotlin.CoroutineCrudRepository

interface UserRepository: CoroutineCrudRepository<User, UUID> {
}