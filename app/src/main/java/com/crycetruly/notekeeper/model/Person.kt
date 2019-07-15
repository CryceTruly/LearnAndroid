package com.crycetruly.notekeeper.model

class Person(var firstName: String, var lastName: String, var age: Int){
    private var fullname:String
        get() = firstName+" "+lastName
        set(value) { firstName+" "+lastName}


fun talk():Any{
    return "$fullname can talk"
}
fun old():Int{
    return age
}

    override fun toString(): String {
        return "Person(firstName='$firstName', lastName='$lastName', age=$age)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Person

        if (firstName != other.firstName) return false
        if (lastName != other.lastName) return false
        if (age != other.age) return false

        return true
    }

    override fun hashCode(): Int {
        var result = firstName.hashCode()
        result = 31 * result + lastName.hashCode()
        result = 31 * result + age
        return result
    }


}