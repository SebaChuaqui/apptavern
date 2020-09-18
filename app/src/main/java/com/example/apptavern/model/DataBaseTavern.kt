package com.example.apptavern.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

private const val DATA_BASE_NAME = "tavern_db"
@Database (entities = [Tavern::class, TavernInfo::class], version = 1)
abstract class DataBaseTavern:RoomDatabase(){

    abstract  fun getTavernDao(): TavernDao
    abstract fun getTavernInfo(): TavernInfoDao

    companion object{

        @Volatile

        private var INSTANCE: DataBaseTavern? = null

        fun getDataBase(context: Context): DataBaseTavern{

            val tempInstance = INSTANCE
            if(tempInstance !=null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(context, DataBaseTavern::class.java, DATA_BASE_NAME).build()
                INSTANCE = instance
                return instance
            }
        }
    }


}
