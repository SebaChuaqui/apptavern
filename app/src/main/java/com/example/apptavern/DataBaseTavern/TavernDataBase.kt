package com.example.apptavern.DataBaseTavern

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

private const val DATA_BASE_NAME = "tavern_db"

@Database(entities = [Tavern::class], version = 1)
abstract class TavernDataBase : RoomDatabase(){

    abstract fun getTavernDao(): TavernDao

    companion object {

        @Volatile

        private var INSTANCE: TavernDataBase? = null

        fun getDatabase(context: Context): TavernDataBase {
            val tempInstance = INSTANCE
            if(tempInstance != null) {
                return  tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(context,
                    TavernDataBase::class.java,
                    DATA_BASE_NAME
                )
                    .build()
                INSTANCE = instance
                return instance
    }
        }
    }
}
