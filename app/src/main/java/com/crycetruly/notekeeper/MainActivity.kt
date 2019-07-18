package com.crycetruly.notekeeper

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.crycetruly.notekeeper.model.CourseInfo
import com.crycetruly.notekeeper.model.NoteInfo
import kotlinx.android.synthetic.main.activity_people.*

class MainActivity : AppCompatActivity() {
    private var selectedNote = POSITION_NOT_SET
    private val TAG=this::class.simpleName


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_people)
        supportActionBar?.title = "Edit Note"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val adapter =
            ArrayAdapter<CourseInfo>(this, android.R.layout.simple_spinner_item, DataManager.courses.values.toList())
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        cousesSpinner.adapter = adapter

        selectedNote =savedInstanceState?.getInt(POSITION, POSITION_NOT_SET)?: intent.getIntExtra(POSITION, POSITION_NOT_SET)
        if (selectedNote != POSITION_NOT_SET) {
            displayNote(selectedNote)
        }else{
            createNewNote()
        }


    }

    private fun createNewNote() {
        DataManager.notes.add(NoteInfo())
        selectedNote = DataManager.notes.lastIndex
    }

    @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putInt(POSITION,selectedNote)

    }

    private fun displayNote(selectedNote: Int) {


        if (selectedNote>DataManager.notes.lastIndex){

            val s: String = "Note not found"
            showMessage(s)
        }


        val note = DataManager.getNote(selectedNote)
        noteTitle.setText(note.title)
        noteText.setText(note.text)
        val course = DataManager.courses.values.indexOf(note.course)
        cousesSpinner.setSelection(course, true)

    }

    override fun onPause() {
        saveNote()
        super.onPause()
    }

    private fun saveNote() {
        val note= DataManager.getNote(selectedNote)
        note.text=noteText.text.toString()
        note.title=noteTitle.text.toString()
        note.course=cousesSpinner.selectedItem as CourseInfo
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {


        return when (item.itemId) {
            R.id.action_next -> {

                if (selectedNote<DataManager.notes.lastIndex){
                    moveNext()
                }else{
                    val s: String = "No more notes"
                    showMessage(s)
                }


                true
            }
            android.R.id.home -> {
                finish()
                true
            }

            else ->

                super.onOptionsItemSelected(item)
        }

    }

    private fun showMessage(s: String) {
        Toast.makeText(this, s, Toast.LENGTH_LONG).show()
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {

        if (selectedNote>=DataManager.notes.lastIndex){
            val menuItem = menu?.findItem(R.id.action_next)
                if(menuItem !=null){
                    menuItem.isEnabled=false
                    @Target()
                    menuItem.icon= getDrawable(R.drawable.ic_action_block)
                }


        }
        return super.onPrepareOptionsMenu(menu)
    }

    private fun moveNext() {
        ++selectedNote
        displayNote(selectedNote)
        invalidateOptionsMenu()

    }
}
