package com.example.dragonfruitapp.ui.theme


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dragonfruitapp.R
import android.content.Intent
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.widget.AppCompatImageView
import com.example.dragonfruitapp.LoginActivity
import com.example.dragonfruitapp.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class RegisterActivity : AppCompatActivity() {

    //private lateinit var rtn: AppCompatImageView
    private lateinit var btnReg: Button
    private lateinit var btnregisterback: Button
    private  lateinit var binding:ActivityRegisterBinding
    private  lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseAuth = FirebaseAuth.getInstance()


        btnReg = findViewById(R.id.btnReg)
        val regButton = findViewById<Button>(R.id.btnReg)

        btnregisterback = findViewById(R.id.btnregisterback)

        btnregisterback.setOnClickListener{
            val bck = Intent(this@RegisterActivity, LoginActivity::class.java)
            startActivity(bck)
        }

        regButton.setOnClickListener{
            val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
            startActivity(intent)
        }

        binding.imageView.setOnClickListener {
            val intent1 = Intent(this, RegisterActivity::class.java)
            startActivity(intent1)
        }

        binding.btnReg.setOnClickListener{
            val email = binding.regUser.text.toString()
            val pass = binding.regPass.text.toString()
            val conPass = binding.regConfirm.text.toString()

            if (email.isNotEmpty() && pass.isNotEmpty() && conPass.isNotEmpty()){
                if (pass == conPass){
                    firebaseAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener{
                        if (it.isSuccessful){

                            val intent1 = Intent(this, LoginActivity::class.java)
                            startActivity(intent1)
                            Toast.makeText(this, "Register Successfully", Toast.LENGTH_SHORT).show()
                        }else{
                            Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                        }
                    }

                }else{
                    Toast.makeText(this, "Unmatched Password & Confirm Password.", Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this, "Empty/Blank inputs are not allowed.", Toast.LENGTH_SHORT).show()
            }
        }


    }
}