package com.example.apptavern.DataBaseTavern

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TavernDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOneTavern(mTavern: Tavern)

    @Update
    suspend fun updateOneTavern(mTavern: Tavern)

    @Delete
    fun deleteOneTavern(mTavern: Tavern)

    @Query("SELECT * FROM table_tavern")
    fun getAllTaskFromDb(): LiveData<List<Tavern>>

    @Query("SELECT * FROM table_tavern WHERE id =:mId")
    fun getOneTaskByID(mId: Int): LiveData<Tavern>

    @Query("DELETE FROM table_tavern")
    suspend fun deleteAllTavern()

}