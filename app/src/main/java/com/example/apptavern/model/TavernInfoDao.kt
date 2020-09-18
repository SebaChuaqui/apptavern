package com.example.apptavern.model

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TavernInfoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOne(mTavernInfo: TavernInfo)

    @Update
    suspend fun updateOne(mTavernInfo: TavernInfo)

    @Query("SELECT * FROM table_info ORDER BY id")
    fun getAllInfo(): LiveData<List<TavernInfo>>

    @Query("SELECT * FROM table_info WHERE id=:mId")
    fun getOneInfo(mId: Int): LiveData<TavernInfo>

    @Query("DELETE FROM table_info")
    suspend fun deleteAll()
}