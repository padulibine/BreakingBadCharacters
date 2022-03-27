package com.example.breakingbadcharacters.DAO

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.breakingbadcharacters.models.PersonnagesItem

@Dao
interface PersonnagesItemDAO {
    @Query("SELECT * FROM PersonnagesItem")
    fun getAll(): List<PersonnagesItem>

    @Insert
    fun insertAll(vararg personnages: PersonnagesItem)
}