package ru.skillbranch.devintensive.utils


object Utils {
    fun parseFullName(fullName:String):Pair<String?,String?>{
        val parts : List<String>? = fullName.split(" ")
        val firstName = parts?.getOrNull(0)
        val lastName = parts?.getOrNull(1)
        return firstName to lastName
    }

    fun transliteration(payload: String, divider :String = " "): String {
        return " "
    }


    fun toInitials(firstName:String? ,lastName: String?): String? {
        val resultF:String? = "${if(firstName != null || firstName != " " || firstName != "") firstName?.toUpperCase()?.get(0) else null }"
        val resultL:String? = "${if(lastName != null || lastName != " " || lastName != "" ) lastName?.toUpperCase()?.get(0) else null }"
        return if (resultF.isNullOrEmpty() && resultL.isNullOrEmpty()) null else "${resultF ?: ""}${resultL ?: ""}"
    }
}