package com.example.dragonfruitapp.ui.theme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dragonfruitapp.R
import android.content.Intent
import androidx.appcompat.widget.AppCompatImageView
import com.example.dragonfruitapp.LoginActivity
import com.example.dragonfruitapp.databinding.ActivityHealthypitayaBinding


class HomePage : AppCompatActivity() {

 //   private lateinit var btnProf: AppCompatImageView
 //    private lateinit var btnback: AppCompatImageView
   // private lateinit var btnimage: AppCompatImageView
  //  private lateinit var btnset: AppCompatImageView

      private lateinit var btnsettings : AppCompatImageView
      private lateinit var btnfileupload: AppCompatImageView
      private lateinit var btnhealthypitaya: AppCompatImageView
      private lateinit var btnpitayapest: AppCompatImageView
      private lateinit var btnpitayadisease: AppCompatImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

          btnsettings = findViewById(R.id.btnsettings)
          btnfileupload = findViewById(R.id.btnfileupload)
          btnhealthypitaya =  findViewById(R.id.btnhealthypitaya)
          btnpitayapest = findViewById(R.id.btnpitayapest)
          //btnpitayadiseases = findViewById(R.id.btnpitayadiseases)

//        btnProf.setOnClickListener{
//            val toProf = Intent(this@HomePage, ProfileActivity::class.java)
//            startActivity(toProf)
//        }

//        btnimage.setOnClickListener{
//        val toImg = Intent(this@HomePage, UploadimageActivity::class.java)
//        startActivity(toImg) }

//        btnset.setOnClickListener{
//        val toset = Intent(this@HomePage, SettingActivity::class.java)
//        startActivity(toset)
//        }

            // Home page Settings button
            btnsettings.setOnClickListener{
            val toSettings = Intent(this@HomePage, SettingActivity::class.java)
            startActivity(toSettings) }

            // Home page Upload image from the galllery
            btnfileupload.setOnClickListener{
            val toImg = Intent(this@HomePage, UploadimageActivity::class.java)
            startActivity(toImg) }

            //Healthy Pitaya
            btnhealthypitaya.setOnClickListener{
                val toHealthy = Intent(this@HomePage, healthypitaya::class.java)
                startActivity(toHealthy)
            }

            //Pitaya Pest
            btnpitayapest.setOnClickListener{
                val toPest = Intent(this@HomePage, PitayapestsActivity::class.java)
                startActivity(toPest)
            }

            // Pitaya Disease
            btnpitayadisease.setOnClickListener{
                val toDisease = Intent(this@HomePage, PitayadiseasesActivity::class.java)
                startActivity(toDisease)
            }
    }
}