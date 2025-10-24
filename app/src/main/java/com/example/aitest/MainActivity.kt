package com.example.aitest

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

/**
 * Launcher-activiteit van de app. Android Studio maakt automatisch een run configuration aan
 * om deze activiteit te starten zodra de Gradle-sync is voltooid.
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val welcomeMessage: TextView = findViewById(R.id.welcomeMessage)
        welcomeMessage.text = getString(R.string.welcome_message)
    }
}
