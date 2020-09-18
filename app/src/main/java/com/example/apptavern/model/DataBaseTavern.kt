package com.example.apptavern.model

import androidx.room.Database
import androidx.room.RoomDatabase

private const val DATA_BASE_NAME = "tavern_db"
@Database (entities = [Tavern::class, TavernInfo::class], version = 1)
abstract class DataBaseTavern:RoomDatabase(){

    abstract  fun getTavernDao(): TavernDao
    abstract fun getTavernInfo(): TavernInfoDao

    
}