package com.unilasalle.helpdeskdores.business.service

import com.google.api.core.ApiFuture
import com.google.cloud.firestore.DocumentSnapshot
import com.google.cloud.firestore.WriteResult
import com.unilasalle.helpdeskdores.business.db.FirebaseInitializer
import com.unilasalle.helpdeskdores.business.model.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService {

    companion object {
        private const val USER_COLLECTION_NAME = "user"
    }

    @Autowired
    private lateinit var firebaseInitializer: FirebaseInitializer

    fun findById(id: String): User? {
        val firestoreDb = firebaseInitializer.getFirebase()
        val documentReference = firestoreDb?.collection(USER_COLLECTION_NAME)?.document(id)
        val documentSnapshot: ApiFuture<DocumentSnapshot> = documentReference?.get() as ApiFuture<DocumentSnapshot>
        val document: DocumentSnapshot = documentSnapshot.get()

        if (document.exists()) {
            return document.toObject(User::class.java)
        } else {
            throw Exception()
        }
    }

    fun registerUser(user: User): String {
        val firestoreDb = firebaseInitializer.getFirebase()
        println(user)
        val collections: ApiFuture<WriteResult> =
            user.id?.let {
                firestoreDb?.collection(USER_COLLECTION_NAME)?.document(it)?.set(user)
            } as ApiFuture<WriteResult>

        return collections.get().updateTime.toString()
    }

    fun update(user: User): String {
        val firestoreDb = firebaseInitializer.getFirebase()
        val apiFuture = user.id?.let {
            firestoreDb?.collection(USER_COLLECTION_NAME)?.document(it)?.set(user)
        } as ApiFuture<WriteResult>

        return apiFuture.get().updateTime.toString()

    }

    fun delete(id: String): String {
        val firestoreDb = firebaseInitializer.getFirebase()
        firestoreDb?.collection(USER_COLLECTION_NAME)?.document(id)?.delete()
        return "User deleted"
    }
}