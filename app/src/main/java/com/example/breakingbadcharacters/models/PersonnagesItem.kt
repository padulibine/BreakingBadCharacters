package com.example.breakingbadcharacters.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PersonnagesItem(

    @PrimaryKey val char_id: Int,
    @ColumnInfo(name = "Name") val name: String,
    @ColumnInfo(name = "Birthday") val birthday: String,
    @ColumnInfo(name = "Image_URL") val img: String,
)