package com.mine.travellooapp

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowInsets
import android.view.WindowManager
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.mine.travellooapp.databinding.ActivityLoginSignupBinding


class Login_Signup : AppCompatActivity() {

    private val binding_login: ActivityLoginSignupBinding by lazy {
        ActivityLoginSignupBinding.inflate(layoutInflater)
    }


    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Full Screen Code
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        setContentView(binding_login.root)

        // Firebase Initializations
        auth = FirebaseAuth.getInstance()

        binding_login.logIn.setOnClickListener {

            val intent = Intent(this, CreateAccount::class.java)
            startActivity(intent)

        }

        binding_login.logInSubmitt.setOnClickListener {

            val email_ = binding_login.emailLogin.text.toString()
            val password_ = binding_login.passwordLogin.text.toString()

            if (email_.isEmpty() || password_.isEmpty()) {
                Toast.makeText(this, "Please Fill Details", Toast.LENGTH_SHORT).show()
            } else {
                auth.signInWithEmailAndPassword(email_, password_)
                    .addOnCompleteListener {
                        if (it.isSuccessful) {
                            startActivity(Intent(this, Home::class.java))
                            finish()
                        }else{
                            Toast.makeText(this, "Sign-In-Failed ${it.exception?.message}", Toast.LENGTH_SHORT).show()
                        }
                    }
            }

        }
    }

    override fun onStart() {
        super.onStart()

        //checking user already log in
        val currentUser : FirebaseUser ?= auth.currentUser
        if(currentUser != null){
            startActivity(Intent(this, Home::class.java))
            finish()
        }
    }

}