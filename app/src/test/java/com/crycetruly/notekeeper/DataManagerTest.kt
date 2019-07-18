package com.crycetruly.notekeeper

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class DataManagerTest {

    @Before
    fun setUp() {
        DataManager.notes.clear()
        DataManager.initializeNotes()
    }

    @Test
    fun addNote() {
        val course=DataManager.courses.get("Test7")!!
        val title="Hello from tests"
        val text="New description from tests"
        val index=DataManager.addNote(course,title,text)
        val note=DataManager.notes[index]
        assertEquals(course,note.course)
        assertEquals(note.text,text)
        assertEquals(note.title,title)
    }

    @Test
    fun findSmilarNotes(){

        val course=DataManager.courses.get("Test7")!!
        val title="Hello from tests"
        val text="New description from tests"
        val text2="New description from tests two"

       val index1= DataManager.addNote(course,title,text)
       val index2= DataManager.addNote(course,title,text2)
        val note=DataManager.findSmilarNote(course,title,text)
        val foundindex=DataManager.notes.indexOf(note)
        assertEquals(index1,foundindex)


        val secnote=DataManager.findSmilarNote(course,title,text2)

        val foundindex2=DataManager.notes.indexOf(secnote)
        assertEquals(index2,foundindex2)
    }
}