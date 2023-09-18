package com.example.dragonfruitapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.dragonfruitapp.databinding.ActivityLoginBinding
import com.example.dragonfruitapp.ui.theme.HomePage
import com.example.dragonfruitapp.ui.theme.RegisterActivity
import com.example.dragonfruitapp.ui.theme.SettingActivity
import com.google.firebase.auth.FirebaseAuth

//------------------RENCEL UPDATED 0.2----------------------------
class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var userName: EditText
    private lateinit var pass: EditText
    private lateinit var btnregister: Button
    private lateinit var btnlogin: Button

    override fun onCreate(SavedInstanceState: Bundle?){
        super.onCreate(SavedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        // LOG IN
        binding.btnLogin.setOnClickListener{
            val email = binding.txtUserName.text.toString()
            val password = binding.txtPass.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                firebaseAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            // Login successful, proceed to the home page
                            val intent = Intent(this, HomePage::class.java)
                            startActivity(intent)
                            finish() // Optional: Finish the LoginActivity so user can't go back
                            Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
                        } else {
                            // Login failed, display the error message
                            val exception = task.exception
                            Toast.makeText(this, exception?.message, Toast.LENGTH_SHORT).show()
                        }
                    }
            } else {
                Toast.makeText(this, "Empty/Blank inputs are not allowed.", Toast.LENGTH_SHORT).show()
            }
        }

        btnlogin = findViewById(R.id.btnLogin)
        btnregister = findViewById(R.id.btnregister)
        userName = findViewById(R.id.txtUserName)
        pass = findViewById(R.id.txtPass)

        // REGISTER
        btnregister.setOnClickListener {
            val username = userName.text.toString()
            val password = pass.text.toString()

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please enter a username and password to register.", Toast.LENGTH_SHORT).show()
            } else {
                // TODO: Register the user using your chosen authentication method
            }

            // If registration is successful, navigate to the home page
            val toHome = Intent(this@LoginActivity, HomePage::class.java)
            startActivity(toHome)
        }
    }
}


//package com.example.dragonfruitapp
//
//import android.content.Intent
//import android.os.Bundle
//import android.widget.Button
//import android.widget.EditText
//import android.widget.Toast
//import androidx.appcompat.app.AppCompatActivity
//import com.example.dragonfruitapp.databinding.ActivityLoginBinding
//import com.example.dragonfruitapp.ui.theme.HomePage
//import com.example.dragonfruitapp.ui.theme.RegisterActivity
//import com.example.dragonfruitapp.ui.theme.SettingActivity
//import com.google.firebase.auth.FirebaseAuth
//
////------------------RENCEL UPDATED 0.1----------------------------
//class LoginActivity : AppCompatActivity() {
//
//    private lateinit var binding: ActivityLoginBinding
//    private lateinit var firebaseAuth: FirebaseAuth
//    private lateinit var userName: EditText
//    private lateinit var pass: EditText
//    private lateinit var btnregister: Button
//    private lateinit var btnlogin: Button
//
//    override fun onCreate(SavedInstanceState: Bundle?){
//        super.onCreate(SavedInstanceState)
//        binding = ActivityLoginBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        firebaseAuth = FirebaseAuth.getInstance()
//
//        // LOG IN
//        binding.btnLogin.setOnClickListener{
//            val email = binding.txtUserName.text.toString()
//            val password = binding.txtPass.text.toString()
//
//            if (email.isNotEmpty() && password.isNotEmpty()) {
//                firebaseAuth.signInWithEmailAndPassword(email, password)
//                    .addOnCompleteListener { task ->
//                        if (task.isSuccessful) {
//                            // Login successful, proceed to the home page
//                            val intent = Intent(this, HomePage::class.java)
//                            startActivity(intent)
//                            finish() // Optional: Finish the LoginActivity so user can't go back
//                            Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
//                        } else {
//                            // Login failed, display the error message
//                            val exception = task.exception
//                            Toast.makeText(this, exception?.message, Toast.LENGTH_SHORT).show()
//                        }
//                    }
//            } else {
//                Toast.makeText(this, "Empty/Blank inputs are not allowed.", Toast.LENGTH_SHORT).show()
//            }
//        }
//
//        btnlogin = findViewById(R.id.btnLogin)
//        btnregister = findViewById(R.id.btnregister)
//        userName = findViewById(R.id.txtUserName)
//        pass = findViewById(R.id.txtPass)
//
//        // REGISTER
//        btnregister.setOnClickListener {
//            val username = userName.text.toString()
//            val password = pass.text.toString()
//
//            if (username.isEmpty() || password.isEmpty()) {
//                Toast.makeText(this, "Please enter a username and password to register.", Toast.LENGTH_SHORT).show()
//               return
//            }
//
//            // TODO: Register the user using your chosen authentication method
//
//            // If registration is successful, navigate to the home page
//            val toHome = Intent(this@LoginActivity, HomePage::class.java)
//            startActivity(toHome)
//        }
//    }
//}

//    package com.example.dragonfruitapp
//
//    import android.content.Intent //imported to be able to use intent, which is to move from one activity to another
//    import android.os.Bundle
//    import android.widget.Button
//    import android.widget.EditText
//    import android.widget.Toast
//    import androidx.appcompat.app.AppCompatActivity
//    import com.example.dragonfruitapp.databinding.ActivityLoginBinding
//    import com.example.dragonfruitapp.ui.theme.HomePage
//    import com.example.dragonfruitapp.ui.theme.RegisterActivity
//    import com.example.dragonfruitapp.ui.theme.SettingActivity
//    import com.google.firebase.auth.FirebaseAuth
//    import com.google.firebase.auth.FirebaseAuthWeakPasswordException
//
//
//     //------------------RENCEL UPDATED----------------------------
//    class LoginActivity : AppCompatActivity() {
//
//        private lateinit var binding: ActivityLoginBinding
//        private lateinit var firebaseAuth: FirebaseAuth
//        private lateinit var userName: EditText
//        private lateinit var pass: EditText
//        private lateinit var btnregister: Button
//        private lateinit var btnlogin: Button
//
//        override fun onCreate(SavedInstanceState: Bundle?){
//            super.onCreate(SavedInstanceState)
//            binding = ActivityLoginBinding.inflate(layoutInflater)
//            setContentView(binding.root)
//            //setContentView(R.layout.activity_login)
//
//            firebaseAuth = FirebaseAuth.getInstance()
//
//            // LOG IN
//            binding.btnLogin.setOnClickListener{
//                val email = binding.txtUserName.text.toString()
//                val password = binding.txtPass.text.toString()
//                if (email.isNotEmpty() && password.isNotEmpty()) {
//                    firebaseAuth.signInWithEmailAndPassword(email, password)
//                        .addOnCompleteListener { task ->
//                            if (task.isSuccessful) {
//                                // Login successful, proceed to the home page
//                                val intent = Intent(this, HomePage::class.java)
//                                startActivity(intent)
//                                finish() // Optional: Finish the LoginActivity so user can't go back
//                                Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
//                            } else {
//                                // Login failed, display the error message
//                                val exception = task.exception
//                                Toast.makeText(this, exception?.message, Toast.LENGTH_SHORT).show()
//                            }
//                        }
//                } else {
//                    Toast.makeText(this, "Empty/Blank inputs are not allowed.", Toast.LENGTH_SHORT).show()
//                }
//            }
//
//            btnregister = findViewById(R.id.btnregister)
//            userName = findViewById(R.id.txtUserName)
//            pass = findViewById(R.id.txtPass)
//            btnlogin = findViewById(R.id.btnLogin)
//
//
//            btnlogin.setOnClickListener {
//                val username = userName.text.toString()
//                val password = pass.text.toString()
//
//
//                if (username == "admin" && password == "pokemon") {
//                    // Successful login
//                    val toHome = Intent(this@LoginActivity, HomePage::class.java)
//                    startActivity(toHome)
//                } else {
//                    // Invalid credentials
//                    Toast.makeText(this, "Invalid username or password", Toast.LENGTH_SHORT).show()
//                }
//            }
//
//            binding.btnregister.setOnClickListener{
//                val intent = Intent(this, RegisterActivity::class.java)
//                startActivity(intent)
//            }
//        }
//    }


//    ---------------------old code---------------------------
//    class LoginActivity : AppCompatActivity() {
//    private lateinit var binding: ActivityLoginBinding
//    private lateinit var firebaseAuth: FirebaseAuth
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityLoginBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        firebaseAuth = FirebaseAuth.getInstance()
//
//        binding.btnLogin.setOnClickListener {
//            val email = binding.txtUserName.text.toString()
//            val password = binding.txtPass.text.toString()
//
//            if (email.isNotEmpty() && password.isNotEmpty()) {
//                firebaseAuth.signInWithEmailAndPassword(email, password)
//                    .addOnCompleteListener { task ->
//                        if (task.isSuccessful) {
//                            // Login successful, proceed to the home page
//                            val intent = Intent(this, HomePage::class.java)
//                            startActivity(intent)
//                            finish() // Optional: Finish the LoginActivity so user can't go back
//                            Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
//                        } else {
//                            // Login failed, display the error message
//                            val exception = task.exception
//                            Toast.makeText(this, exception?.message, Toast.LENGTH_SHORT).show()
//                        }
//                    }
//            } else {
//                Toast.makeText(this, "Empty/Blank inputs are not allowed.", Toast.LENGTH_SHORT).show()
//            }
//        }
//
//        binding.btnregister.setOnClickListener {
//            val intent = Intent(this, RegisterActivity::class.java)
//            startActivity(intent)
//        }
//    }
//}
//
