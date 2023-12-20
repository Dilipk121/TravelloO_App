package com.mine.travellooapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.ImageView

class SlideScreenOne : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        setContentView(R.layout.activity_slide_screen_one)

        val btn_next = findViewById<ImageView>(R.id.next_btn)

        btn_next.setOnClickListener{

            val intent = Intent(this,SlideScreenTwo::class.java)
            startActivity(intent)
            finish()

        }
    }
}