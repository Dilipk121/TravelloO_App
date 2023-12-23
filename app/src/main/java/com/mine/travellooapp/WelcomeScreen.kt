package com.mine.travellooapp

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowInsets
import android.view.WindowManager

class WelcomeScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )


        setContentView(R.layout.activity_welcome_screen)

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, SlideScreenOne::class.java))
            finish()
        }, 3000)

    }

}
