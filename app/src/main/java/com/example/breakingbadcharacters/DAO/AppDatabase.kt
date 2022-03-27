package com.example.breakingbadcharacters.DAO

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.breakingbadcharacters.models.PersonnagesItem

@Database(entities = [PersonnagesItem::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): PersonnagesItemDAO
}