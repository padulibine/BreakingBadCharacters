package com.example.breakingbadcharacters.converters

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.google.gson.Gson

@ProvidedTypeConverter
class OccupationConverter {

    @TypeConverter
    fun occupationToJson(occupation: List<String>?): String? {
        val gson = Gson()
        return gson.toJson(occupation)
    }

    @TypeConverter
    fun jsonToOccupation(json : String): List<String>? {
        //TODO : passer du Json à la liste
        val list = listOf<String>(json)
        return list
    }
}