package com.example.dragonfruitapp.ui.theme

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.dragonfruitapp.LoginActivity
import com.example.dragonfruitapp.R


class SplashActivity : AppCompatActivity() {
    private val splashTimeout: Long = 2000 // Adjust this value as needed (milliseconds)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Use a Handler to delay the navigation to the Login screen
        Handler().postDelayed({
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }, splashTimeout)
    }
}
