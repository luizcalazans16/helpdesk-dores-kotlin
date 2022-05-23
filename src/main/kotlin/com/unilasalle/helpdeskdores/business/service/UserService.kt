package com.unilasalle.helpdeskdores.business.service

import com.google.api.core.ApiFuture
import com.google.cloud.firestore.DocumentSnapshot
import com.google.cloud.firestore.WriteResult
import com.unilasalle.helpdeskdores.business.model.User
import com.unilasalle.helpdeskdores.business.repository.FirestoreDatabase
import org.springframework.stereotype.Service

@Service
class UserService {

    companion object {
        val firestoreDb = FirestoreDatabase().setupDatase()
    }

    fun findById(id: String): User? {
        val documentReference = firestoreDb?.collection("user")?.document(id)
        val documentSnapshot: ApiFuture<DocumentSnapshot> = documentReference?.get() as ApiFuture<DocumentSnapshot>
        val document: DocumentSnapshot = documentSnapshot.get()
        val user: User
        if (document.exists()) {
            val storedUser = document.toObject(User::class.java)
            storedUser?.let {
                user = it
                return user
            }
        }
        return null

    }

    fun registerUser(user: User): String {
        val collections: ApiFuture<WriteResult> =
            firestoreDb?.collection("user")?.document(user.name)?.set(user) as ApiFuture<WriteResult>

        return collections.get().updateTime.toString()
    }

    fun update(id: String, user: User) {

        TODO("Not yet implemented")
    }

}