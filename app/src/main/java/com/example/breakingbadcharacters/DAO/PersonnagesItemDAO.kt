package com.example.breakingbadcharacters.DAO

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.breakingbadcharacters.models.PersonnagesItem

@Dao
interface PersonnagesItemDAO {
    @Query("SELECT * FROM personnages")
    fun getAll(): MutableList<PersonnagesItem>

    @Insert
    fun insertAll(personnages: PersonnagesItem)

    @Delete
    fun delete(personnages: PersonnagesItem)
    

}