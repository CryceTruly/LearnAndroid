package com.crycetruly.notekeeper.model

@Suppress("UNUSED_PARAMETER")
data class Person(var firstName: String, var lastName: String, var age: Int) {
    private var fullname:String
        get() = firstName+" "+lastName
        set(value) { firstName+" "+lastName}


fun talk():Any{
    return "$fullname can talk"
}
fun old():Int{
    return age
}
}