package com.example.breakingbadcharacters.DAO

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.breakingbadcharacters.fragments.FragmentMain
import com.example.breakingbadcharacters.models.PersonnagesItem


@Database(entities = [PersonnagesItem::class], version = 1)
abstract class AppDatabase  : RoomDatabase() {
    abstract fun personnagesItemDAO(): PersonnagesItemDAO
}
