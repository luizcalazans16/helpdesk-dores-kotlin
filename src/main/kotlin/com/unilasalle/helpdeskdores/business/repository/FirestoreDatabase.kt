package com.unilasalle.helpdeskdores.business.repository

import com.google.cloud.firestore.Firestore
import com.google.firebase.cloud.FirestoreClient
import org.springframework.stereotype.Component

@Component
class FirestoreDatabase {

    fun setupDatase(): Firestore? {
        return FirestoreClient.getFirestore()
    }
}