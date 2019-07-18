package com.crycetruly.notekeeper

import com.crycetruly.notekeeper.model.CourseInfo
import com.crycetruly.notekeeper.model.NoteInfo

object  DataManager {
    val courses=HashMap<String,CourseInfo>()
    val notes=ArrayList<NoteInfo>()

    init {
        initializeCourses()
        initializeNotes()
    }


    fun addNote(course:CourseInfo,noteTitle:String,noteText:String):Int{
        val note=NoteInfo(course,noteTitle,noteText)
        notes.add(note)
        return notes.lastIndex;
    }

    fun findSmilarNote(course:CourseInfo,noteTitle:String,noteText:String): NoteInfo? {

        for (note in notes){
            if(note.course==course&&note.title==noteTitle&&note.text==noteText){
                return note
            }
        }


    return null
    }

     fun initializeCourses(){

        val course7 = CourseInfo("Test7", "Ruby Programming")
        courses.set(course7.courseId,course7)
        val course = CourseInfo("Test1", "Java Programming")
        courses.set(course.courseId,course)
        val course2 = CourseInfo("Test2", "Kotlin Programming")
        courses.set(course2.courseId,course2)
        val course3 = CourseInfo("Test3", "Python Programming")
        courses.set(course3.courseId,course3)
        courses.set(CourseInfo("Test67","Javascript Programming").courseId,CourseInfo("Test67","Javascript Programming"))

    }

     fun initializeNotes(){
        val course = CourseInfo("Test1", "Java Programming")
        val course2 = CourseInfo("Test2", "Kotlin Programming")
        val course3 = CourseInfo("Test3", "Python Programming")

        val note=NoteInfo(course,course.title,"Java is old")
        notes.add(note)
        val note2=NoteInfo(course2,course2.title,"Kotlin is new")
        notes.add(note2)
        val note3=NoteInfo(course3,course3.title,"Python is aws hehehe")
        notes.add(note3)


    }


    fun getNote(position: Int): NoteInfo {
        return notes[position]
    }
}