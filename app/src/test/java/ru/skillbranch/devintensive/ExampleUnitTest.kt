package ru.skillbranch.devintensive

import org.junit.Test

import org.junit.Assert.*
import ru.skillbranch.devintensive.extensions.TimeUnits
import ru.skillbranch.devintensive.extensions.add
import ru.skillbranch.devintensive.extensions.format
import ru.skillbranch.devintensive.extensions.toUserView
import ru.skillbranch.devintensive.models.*
import java.util.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun test_instance() {
        val user1 = User("1")
        val user2 = User("2")
        val user3 = User("3")

        user1.printMe()

        println("$user1 $user2 $user3")
    }

    @Test
    fun test_factory(){
        val user = User.makeUser("John Wick")
        val user2 = user.copy(id = "2",lastName = "Cena")
        print("$user \n $user2")
    }
    @Test
    fun test_decomposition(){
        val user = User.makeUser("John Wick")

        fun getUser() = user

        val (id,firsName,lastName) = getUser()

        println("$id, $firsName, $lastName")
    }

    @Test
    fun test_copy(){
        val user = User.makeUser("John Wick")
        var user1 = user.copy(lastVisit = Date())
        var user2 = user.copy(lastVisit = Date().add(-2,TimeUnits.SECOND))
        var user3 = user.copy(lastName = "Cena",lastVisit = Date().add(2,TimeUnits.HOUR))

        println("""
            ${user.lastVisit?.format()}
            ${user1.lastVisit?.format()}
            ${user2.lastVisit?.format()}
            ${user3.lastVisit?.format()}
        """.trimIndent())
    }

    @Test
    fun test_dataq_maping(){
        val user = User.makeUser("Ashimov Adilbek")
        val newUser = user.copy(lastVisit = Date().add(-4,TimeUnits.DAY))
        println(newUser)

        val userView = newUser.toUserView()
        userView.printMe()
    }

    @Test
    fun test_abstract_factory(){
        val user = User.makeUser("Ashimov Adilbek")
        val txtMessage = BaseMessage.makeMessage(user, Chat("0"),payload = "any text message", type = "text")
        val imgMessage = BaseMessage.makeMessage(user, Chat("0"),payload = "any image url", type = "image")
         println(txtMessage.formatMessage())
         println(imgMessage.formatMessage())
    }

}
