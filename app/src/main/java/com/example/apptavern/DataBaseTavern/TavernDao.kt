package com.example.apptavern.DataBaseTavern

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TavernDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOneBar(mTavern: Tavern)

    @Update
    suspend fun updateOneTask(mTavern: Tavern)

    @Delete
    fun deleteOneTask(mTavern: Tavern)

    @Query("SELECT * FROM table_tavern")
    fun getAllTaskFromDb(): LiveData<List<Tavern>>

    // Busca un elemento por ID
    @Query("SELECT * FROM table_tavern WHERE id =:mId")
    fun getOneTaskByID(mId: Int): LiveData<Tavern>

    @Query("DELETE FROM table_tavern")
    suspend fun deleteAllTask()

}