package com.example.apptavern

import androidx.lifecycle.LiveData
import com.example.apptavern.DataBaseTavern.Tavern
import com.example.apptavern.DataBaseTavern.TavernDao

class TavernRepository(private val mTavernDao: TavernDao) {

    val listAllTavern : LiveData<List<Tavern>> = mTavernDao.getAllTaskFromDb()

    suspend fun insertTavern(mTavern: Tavern) {
        mTavernDao.insertOneTavern(mTavern)
    }

    suspend fun deleteAll(){
        mTavernDao.deleteAllTavern()
    }

    fun getOneTaskByID(id : Int): LiveData<Tavern>{
        return mTavernDao.getOneTaskByID(id)
    }

    suspend fun updateTavern(mTavern: Tavern){
        mTavernDao.updateOneTavern(mTavern)
    }

}