package com.mine.travellooapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.mine.travellooapp.databinding.ActivityCreateNewNotesBinding

class CreateNewNotes : AppCompatActivity() {

    private val bindeNotes: ActivityCreateNewNotesBinding by lazy {

        ActivityCreateNewNotesBinding.inflate(layoutInflater)
    }
    private lateinit var databaseReference: DatabaseReference
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(bindeNotes.root)

        //initialize firebase database reference

        databaseReference = FirebaseDatabase.getInstance().reference
        auth = FirebaseAuth.getInstance()

        bindeNotes.saveNote.setOnClickListener {

            //get text from edittext
            val title = bindeNotes.titleNote.text.toString()
            val description = bindeNotes.descriptionNote.text.toString()

            if (title.isNotEmpty() && description.isEmpty()) {

                Toast.makeText(this, "file the all fields", Toast.LENGTH_SHORT).show()

            } else {
                val currentUser: FirebaseUser? = auth.currentUser

                currentUser?.let { user ->
                    // generating unique key for every notes
                    val noteKey: String? = databaseReference.child("users").child(user.uid)
                        .child("notes").push().key

                    //note item intences
                    val noteItem = NoteItems(title, description)

                    if (noteKey != null) {
                        //add notes to the user note
                        databaseReference.child("users").child(user.uid).child("notes")
                            .setValue(noteItem).addOnCompleteListener {

                                if (it.isSuccessful) {
                                    Toast.makeText(
                                        this,
                                        "Note Save Successfully",
                                        Toast.LENGTH_SHORT
                                    )
                                        .show()
                                    finish()
                                } else {
                                    Toast.makeText(this, it.exception?.message, Toast.LENGTH_SHORT)
                                        .show()
                                }
                            }
                    }
                }
            }
        }
    }
}