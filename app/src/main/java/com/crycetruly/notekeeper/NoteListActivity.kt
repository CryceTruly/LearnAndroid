package com.crycetruly.notekeeper

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.crycetruly.notekeeper.model.NoteInfo

import kotlinx.android.synthetic.main.activity_note_list.*
import kotlinx.android.synthetic.main.content_note_list.*

class NoteListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_note_list)

        supportActionBar?.title = "Notes"
        supportActionBar?.subtitle=DataManager.notes.size.toString()

        fab.setOnClickListener { view ->
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val adapter = ArrayAdapter<NoteInfo>(this, android.R.layout.simple_list_item_1, DataManager.notes)
        noteList.adapter = adapter

        noteList.setOnItemClickListener { adapterView, view, i, l ->
            val intent = Intent(baseContext, MainActivity::class.java)
            intent.putExtra(POSITION, i)
            startActivity(
                intent
            )
        }
    }

    override fun onResume() {
        (noteList.adapter as ArrayAdapter<*>).notifyDataSetChanged()
        super.onResume()
    }


}
