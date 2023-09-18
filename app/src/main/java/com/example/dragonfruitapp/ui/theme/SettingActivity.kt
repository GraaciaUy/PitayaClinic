package com.example.dragonfruitapp.ui.theme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dragonfruitapp.R
import androidx.appcompat.widget.AppCompatImageView
import android.content.Intent

class SettingActivity : AppCompatActivity() {

    private lateinit var btnhme : AppCompatImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)

        btnhme = findViewById(R.id.imageView4)

        btnhme.setOnClickListener {
            val sethme = Intent(this@SettingActivity, HomePage::class.java)
            startActivity(sethme)
        }
    }
}