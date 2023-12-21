package com.mine.travellooapp

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowInsets
import android.view.WindowManager
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.mine.travellooapp.databinding.ActivityCreateAccountBinding

class CreateAccount : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    private val binding: ActivityCreateAccountBinding by lazy {
        ActivityCreateAccountBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        // Full Screen Code
        @Suppress("DEPRECATION")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }

        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_create_account)
        setContentView(binding.root)

        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance()


        binding.logIn.setOnClickListener {
            val intent = Intent(this, Login_Signup::class.java)
            startActivity(intent)
            finish()
        }

        binding.submitFinal.setOnClickListener {

            //text getting from user filled
            val full_name = binding.fullName.text.toString()
            val email = binding.email.text.toString()
            val mobile = binding.mobile.text.toString()
            val password = binding.password.text.toString()

            // check data if there is any blank

            if (full_name.isEmpty() || email.isEmpty() || mobile.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please Fill All Details", Toast.LENGTH_SHORT).show()
            }
            else{
                auth.createUserWithEmailAndPassword(email,password)
                    .addOnCompleteListener(this){

                        if(it.isSuccessful){
                            Toast.makeText(this, "Registration Successful", Toast.LENGTH_SHORT).show()
                            startActivity(Intent(this,Login_Signup::class.java))
                            finish()
                        }
                        else{
                            Toast.makeText(this, "Registration Failed ${it.exception?.message}", Toast.LENGTH_SHORT).show()
                        }

                    }
            }


        }
    }
}