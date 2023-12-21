package com.mine.travellooapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.mine.travellooapp.databinding.ActivityHomeBinding

class Home : AppCompatActivity() {

    private lateinit var auth_home:FirebaseAuth

    private val binding_home : ActivityHomeBinding by lazy {
        ActivityHomeBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding_home.root)



        binding_home.logOut.setOnClickListener{

            auth_home = FirebaseAuth.getInstance()
            auth_home.signOut()
            Toast.makeText(this, "Sign-out Successfully!", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this,Login_Signup::class.java))
            finish()

        }






    }
}