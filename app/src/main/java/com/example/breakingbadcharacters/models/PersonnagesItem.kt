package com.example.breakingbadcharacters.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "personnages")
data class PersonnagesItem(

    @PrimaryKey val char_id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "birthday") val birthday: String,
    @ColumnInfo(name = "image_URL") val img: String,
    @ColumnInfo(name = "appearance") val appearance: List<Any>?,
    @ColumnInfo(name = "better_call_saul_appearance") val better_call_saul_appearance: List<Int>?,
    @ColumnInfo(name = "category") val category: String?,
    @ColumnInfo(name = "nickname") val nickname: String?,
    @ColumnInfo(name = "occupation") val occupation: List<String>?,
    @ColumnInfo(name = "portrayed") val portrayed: String?,
    @ColumnInfo(name = "status") val status: String?
)