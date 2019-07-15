package com.crycetruly.notekeeper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.crycetruly.notekeeper.model.Person

class PeopleActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_people)

        var person=Person("Cryce","Truly",24)
        var person2=Person("Amon","Kanyesigye",27)
        var person3=Person("Andinda","Adia",21)
        var person4=Person("Corey","Mschafer",29)

        var people= arrayOf(person.firstName,person2.firstName,person4.firstName,person3.firstName)
        people.forEach { per-> print(per) }







    }
}
