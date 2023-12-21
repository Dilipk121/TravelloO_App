package com.mine.travellooapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mine.travellooapp.databinding.ActivityNotesApplicationBinding

class NotesApplication : AppCompatActivity() {

    private val binding_notes : ActivityNotesApplicationBinding by lazy {

        ActivityNotesApplicationBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding_notes.root)


    }
}