package com.example.apptavern.model

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TavernDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOne(mTavern: Tavern)

    @Update
    suspend fun updateOne(mTavern: Tavern)

    @Query("SELECT * FROM table_tavern ORDER BY id")
    fun getAllTavern(): LiveData<List<Tavern>>

    @Query("SELECT * FROM table_tavern WHERE id=:mId")
    fun getOneTavern(mId: Int): LiveData<Tavern>

    @Query("DELETE FROM table_tavern")
    suspend fun deleteAll()
}