package com.example.apptavern.model

import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

interface TavernInfoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOne(mTavernInfo: TavernInfo)

    @Update
    suspend fun updateOne(mTavernInfo: TavernInfo)

    @Query("SELECT * FROM table_info ORDER BY id")
    fun getAllInfo(): LiveData<List<Tavern>>

    @Query("SELECT * FROM table_info WHERE id=:mId")
    fun getOneInfo(mId: Int): LiveData<Tavern>

    @Query("DELETE FROM table_info")
    suspend fun deleteAll()
}