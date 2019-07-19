package com.crycetruly.notekeeper


import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import androidx.test.espresso.Espresso.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.contrib.DrawerActions
import androidx.test.espresso.contrib.NavigationViewActions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test

@RunWith(JUnit4::class)
class NavigationTest{


    @JvmField
    @Rule
    val itemsActivity=ActivityTestRule(ItemsActivity::class.java)


    @Test
    fun selectNoteAfterNavDrawerChange(){
        onView(withId(R.id.drawer_layout)).perform(DrawerActions.open())
        onView(withId(R.id.nav_view)).perform(NavigationViewActions.navigateTo(R.id.nav_courses))
        onView(withId(R.id.noteList)).perform(RecyclerViewActions.actionOnItemAtPosition<CourseRecyclerAdapter.ItemViewHolder>(0,
            click()))


         }
    @Test
    fun selectNotes(){
        onView(withId(R.id.drawer_layout)).perform(DrawerActions.open())
        onView(withId(R.id.nav_view)).perform(NavigationViewActions.navigateTo(R.id.nav_notes))
        onView(withId(R.id.noteList)).perform(RecyclerViewActions.actionOnItemAtPosition<NoteRecyclerAdapter.ItemViewHolder>(0,
            click()))
        onView(withId(R.id.noteTitle)).perform( typeText(DataManager.notes[0].title))
        onView(withId(R.id.noteText)).perform(typeText(DataManager.notes[0].text))

    }

    @Test
    fun selectNotes2(){
        onView(withId(R.id.drawer_layout)).perform(DrawerActions.open())
        onView(withId(R.id.nav_view)).perform(NavigationViewActions.navigateTo(R.id.nav_notes))
        onView(withId(R.id.noteList)).perform(RecyclerViewActions.actionOnItemAtPosition<NoteRecyclerAdapter.ItemViewHolder>(1,
            click()))
        onView(withId(R.id.noteTitle)).perform( typeText(DataManager.notes[1].title))
        onView(withId(R.id.noteText)).perform(typeText(DataManager.notes[1].text))

    }

}