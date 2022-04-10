package com.example.breakingbadcharacters.DAO

import androidx.room.*
import com.example.breakingbadcharacters.converters.AppearanceConverter
import com.example.breakingbadcharacters.converters.BcsAppearanceConverter
import com.example.breakingbadcharacters.converters.OccupationConverter
import com.example.breakingbadcharacters.models.PersonnagesItem


@Database(entities = [PersonnagesItem::class], version = 4)
@TypeConverters(OccupationConverter::class, AppearanceConverter::class, BcsAppearanceConverter::class)
abstract class AppDatabase  : RoomDatabase() {
    abstract fun personnagesItemDAO(): PersonnagesItemDAO
}
