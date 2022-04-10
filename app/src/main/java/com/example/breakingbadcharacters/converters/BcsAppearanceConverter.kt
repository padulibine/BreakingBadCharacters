package com.example.breakingbadcharacters.converters

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.google.gson.Gson

@ProvidedTypeConverter
class BcsAppearanceConverter {
    @TypeConverter
    fun bcsAppearanceToJson(bcsAppearance: List<Int>?): String? {
        val gson = Gson()
        return gson.toJson(bcsAppearance)
    }

    @TypeConverter
    fun jsonTobcsAppearance(json : String): List<Int>? {
        //TODO : passer du Json à la liste
        val list = listOf<Int>(1)
        return list
    }
}