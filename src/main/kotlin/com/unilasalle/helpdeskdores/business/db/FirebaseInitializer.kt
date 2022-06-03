package com.unilasalle.helpdeskdores.business.db

import com.google.auth.oauth2.GoogleCredentials
import com.google.cloud.firestore.Firestore
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.cloud.FirestoreClient
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import java.io.IOException
import java.io.InputStream
import javax.annotation.PostConstruct

@Component
class FirebaseInitializer {

    @Bean
    fun firebaseAuth(): FirebaseAuth? {
        return FirebaseAuth.getInstance()
    }

    @PostConstruct
    fun initDb() {
        val serviceAccount: InputStream = javaClass.getResourceAsStream("/firebase_config.json") as InputStream

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