package com.example.breakingbadcharacters.converters

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.google.gson.Gson

@ProvidedTypeConverter
class AppearanceConverter {
    @TypeConverter
    fun appearanceToJson(bcsAppearance: List<Any>?): String? {
        val gson = Gson()
        return gson.toJson(bcsAppearance)
    }

    @TypeConverter
    fun jsonToAppearance(json : String): List<Any>? {
        //TODO : passer du Json à la liste
        val list = listOf<Any>(json)
        return list
    }
}