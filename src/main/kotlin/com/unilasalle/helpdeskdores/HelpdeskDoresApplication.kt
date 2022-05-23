package com.unilasalle.helpdeskdores

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.io.File
import java.io.FileInputStream
import java.io.IOException


@SpringBootApplication
class HelpdeskDoresApplication

fun main(args: Array<String>) {

    val file = File("src/main/resources/firebase_config.json")
    val serviceAccount =
        FileInputStream(file.absoluteFile)

    runApplication<HelpdeskDoresApplication>(*args)
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

