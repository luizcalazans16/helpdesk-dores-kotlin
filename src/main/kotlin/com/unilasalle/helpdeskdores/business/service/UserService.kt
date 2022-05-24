package com.unilasalle.helpdeskdores.business.service

import com.google.api.core.ApiFuture
import com.google.cloud.firestore.DocumentSnapshot
import com.google.cloud.firestore.WriteResult
import com.google.firebase.cloud.FirestoreClient
import com.unilasalle.helpdeskdores.business.model.User
import org.springframework.stereotype.Service

@Service
class UserService {

    fun findById(id: String): User? {
        val firestoreDb = FirestoreClient.getFirestore()
        val documentReference = firestoreDb.collection("user").document(id)
        val documentSnapshot: ApiFuture<DocumentSnapshot> = documentReference.get() as ApiFuture<DocumentSnapshot>
        val document: DocumentSnapshot = documentSnapshot.get()

        if (document.exists()) {
            return document.toObject(User::class.java)
        } else {
            throw Exception()
        }
    }

    fun registerUser(user: User): String {
        val firestoreDb = FirestoreClient.getFirestore()
        val collections: ApiFuture<WriteResult> =
            user.name?.let { firestoreDb?.collection("user")?.document(it)?.set(user) } as ApiFuture<WriteResult>

        return collections.get().updateTime.toString()
    }

//    fun update(id: String, user: User) {
//        val user = findById(id)
//    }

    fun delete(id: String): String {
        val firestoreDb = FirestoreClient.getFirestore()
        firestoreDb?.collection("user")?.document(id)?.delete()
        return "User deleted"
    }

}