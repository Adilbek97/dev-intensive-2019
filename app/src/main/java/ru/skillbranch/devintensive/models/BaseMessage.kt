package ru.skillbranch.devintensive.models

import java.util.*

abstract class BaseMessage(
    val id:String,
    val from:User?,
    val chat:Chat,
    val isIncoming:Boolean = false,
    val date: Date = Date()
) {
    abstract fun formatMessage():String
    companion object AbstractFactory{
        var lastID = -1
        fun makeMessage(from:User?,chat: Chat, date: Date = Date(), type:String = "text", payload: Any?):BaseMessage{
            return when(type){
                "image" -> ImageMessage(id = "$lastID", from = from,chat = chat, date= date, image= payload as String)
                else -> TextMessage(id = "$lastID", from = from,chat = chat, date= date, text= payload as String)
            }
        }
    }
}