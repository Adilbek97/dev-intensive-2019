package ru.skillbranch.devintensive.models

import ru.skillbranch.devintensive.utils.Utils
import java.util.*

data class User(
    val id:String,
    val firstName:String?,
    val lastName:String?,
    var avatar: String?,
    var rating:Int = 0,
    var respect:Int = 0,
    val lastVisit: Date? = null,
    val isOnline: Boolean = false
) {
    var introBit:String
    constructor(id: String, firstName: String?,lastName: String?) : this(
        id=id,
        firstName = firstName,
        lastName = lastName,
        avatar = null
    )

    constructor(id:String) : this(id,"John","Doe $id")

    init {
        introBit = getIntro()
        println("It's Alive!!! \n"+
                "${if(lastName === "Doe") "His name is $firstName $lastName" else "And name is $firstName $lastName!!!"}\n"+
                getIntro()
        )
    }

    private fun getIntro(): String =
        """djnsf sdf ksd fsd kd
            sdfsddsfsf
        """.trimMargin()


    fun printMe() = println("id: $id, \n" +
                "firstName: $firstName,\n" +
                "lastName: $lastName,\n" +
                "avatar: $avatar,\n" +
                "rating: $rating,\n" +
                "respect: $respect,\n" +
                "lastVisit: $lastVisit, \n" +
                "isOnline: $isOnline")
        companion object Factory{
            private var lastId = -1

            fun makeUser(fullName:String):User{
                lastId++
                val (firstName, lastName) = Utils.parseFullName(fullName)
                return User(id = "$lastId",firstName = firstName, lastName = lastName)
            }
        }

}