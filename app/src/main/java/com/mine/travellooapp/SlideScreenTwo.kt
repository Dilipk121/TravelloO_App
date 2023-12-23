package com.mine.travellooapp

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowInsets
import android.view.WindowManager
import android.widget.ImageView

class SlideScreenTwo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        setContentView(R.layout.activity_slide_screen_two)

        val btn_next = findViewById<ImageView>(R.id.next_btn)

        btn_next.setOnClickListener{

            val intent = Intent(this,SlideScreenThree::class.java)
            startActivity(intent)
            finish()

        }
    }
}