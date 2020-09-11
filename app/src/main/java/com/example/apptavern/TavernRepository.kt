package com.example.apptavern

import androidx.lifecycle.LiveData
import com.example.apptavern.DataBaseTavern.Tavern
import com.example.apptavern.DataBaseTavern.TavernDao

class TavernRepository(private val mTavernDao: TavernDao) {

    val listAllTavern : LiveData<List<Tavern>> = mTavernDao.getAllTaskFromDb()
}