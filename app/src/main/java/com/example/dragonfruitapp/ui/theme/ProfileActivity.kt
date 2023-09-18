package com.example.dragonfruitapp.ui.theme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dragonfruitapp.R
import android.content.Intent
import androidx.appcompat.widget.AppCompatImageView

class ProfileActivity : AppCompatActivity() {

    private lateinit var profbck : AppCompatImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        profbck = findViewById(R.id.btnprofileback)

        profbck.setOnClickListener {
            val photobck = Intent(this@ProfileActivity, HomePage::class.java)
            startActivity(photobck)
        }
    }
}