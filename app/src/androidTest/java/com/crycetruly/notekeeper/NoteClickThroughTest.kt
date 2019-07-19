package com.crycetruly.notekeeper

import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.runner.RunWith
import org.junit.runners.JUnit4


import androidx.test.espresso.Espresso.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.espresso.action.ViewActions.*
import org.hamcrest.Matchers.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import org.junit.Test

@RunWith(JUnit4::class)
class NoteClickThroughTest{

    @JvmField
    @Rule
    val noteListActivity=ActivityTestRule(NoteListActivity::class.java)

    @Test
    fun WalkThrough(){
        onData(allOf(instanceOf(NoteInfo::class.java), equalTo(DataManager.notes[0]))).perform(click())

        onView(withId(R.id.action_next)).check(matches(isEnabled()))
        for (index in 0..DataManager.notes.lastIndex){
            val note=DataManager.notes[index]
            onView(withId(R.id.cousesSpinner)).check(matches(withSpinnerText(note.course?.title)))
            onView(withId(R.id.noteText)).check(matches(withText(note.text)))
            onView(withId(R.id.noteTitle)).check(matches(withText(note.title)))


            if (index!=DataManager.notes.lastIndex){
                onView(allOf(withId(R.id.action_next), isEnabled())).perform(click())
            }
        }

        onView(withId(R.id.action_next)).check(matches(not(isEnabled())))
    }
}