package com.crycetruly.notekeeper

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.crycetruly.notekeeper.model.Person

class PeopleActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_people)

        val person = Person("Cryce", "Truly", 24)
        val person2 = Person("Amon", "Kanyesigye", 27)
        val person3 = Person("Andinda", "Adia", 21)
        val person4 = Person("Corey", "Mschafer", 29)

        val people = arrayOf(person.firstName, person2.firstName, person4.firstName, person3.firstName)
        people.forEach { per-> print(per) }







    }
}
