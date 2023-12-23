package com.mine.travellooapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.mine.travellooapp.databinding.ActivityNotesApplicationBinding

class NotesApplication : AppCompatActivity() {

    private val binding_notes : ActivityNotesApplicationBinding by lazy {

        ActivityNotesApplicationBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding_notes.root)

        binding_notes.createNewNotes.setOnClickListener{

            Toast.makeText(this, "Create New Notes", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this,CreateNewNotes::class.java))

        }


    }
}