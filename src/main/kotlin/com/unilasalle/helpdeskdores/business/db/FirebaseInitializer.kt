package com.unilasalle.helpdeskdores.business.db

import com.google.auth.oauth2.GoogleCredentials
import com.google.cloud.firestore.Firestore
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.cloud.FirestoreClient
import java.io.File
import java.io.FileInputStream
import java.io.IOException
import javax.annotation.PostConstruct
import org.springframework.stereotype.Component

@Component
class FirebaseInitializer {

    @PostConstruct
    fun initDb() {
        val file = File("src/main/resources/firebase_config.json")
        val serviceAccount =
            FileInputStream(file.absoluteFile)
        try {
            val options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://helpdesk-dores-default-rtdb.firebaseio.com")
                .build()

            if (FirebaseApp.getApps().isEmpty()) {
                FirebaseApp.initializeApp(options)
            }

        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    fun getFirebase(): Firestore? {
        return FirestoreClient.getFirestore()
    }
}