package com.crycetruly.notekeeper
import androidx.test.rule.ActivityTestRule
import org.junit.After
import org.junit.Before

import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import androidx.test.espresso.Espresso.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.espresso.action.ViewActions.*
import org.hamcrest.Matchers.*
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
@RunWith(JUnit4::class)
class CreateNewNoteTest {

    @Rule
    @JvmField
    val noteListActivity= ActivityTestRule(NoteListActivity::class.java)

    @Before
    fun setUp() {

    }

    @After
    fun tearDown() {
    }


    @Test
    fun createNote(){
        val title="Hello new title"
        val text="This is the test"

        onView(withId(R.id.fab)).perform(click())
        onView(withId(R.id.noteTitle)).perform( typeText(title))
        onView(withId(R.id.noteText)).perform(typeText(text))
        onView(withId(R.id.cousesSpinner)).perform(click())
        onData(allOf(instanceOf(CourseInfo::class.java), equalTo(DataManager.courses["Test7"]))).perform(click(),
            closeSoftKeyboard())
        pressBack()
        val newNote=DataManager.notes.last()
        assertEquals(newNote.course,DataManager.courses["Test7"])
        assertEquals(newNote.text,text)
        assertEquals(newNote.title,title)
    }
}

