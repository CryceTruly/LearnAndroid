package com.crycetruly.notekeeper

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.crycetruly.notekeeper.model.NoteInfo
import kotlinx.android.synthetic.main.content_note_list.*

class NoteListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_note_list)

        supportActionBar?.title = "Notes"
        supportActionBar?.subtitle=DataManager.notes.size.toString()


        noteList.layoutManager=LinearLayoutManager(this)


        fab.setOnClickListener { view ->
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


    }



}
