package com.example.apptavern.model

import androidx.lifecycle.LiveData

class TavernRepository(private val mTavernDao: TavernDao, private val mTavernInfoDao: TavernInfoDao) {

    val mListAllTavern : LiveData<List<Tavern>> = mTavernDao.getAllTavern()
    val mListAllTavernInfo : LiveData<List<TavernInfo>> = mTavernInfoDao.getAllInfo()

    suspend fun insertTavern(mTavern: Tavern){
        mTavernDao.insertOne(mTavern)
    }

    suspend fun insertTavernInfo(mTavernInfo: TavernInfo){
        mTavernInfoDao.insertOne(mTavernInfo)
    }

    suspend fun deleteAllTavern(){
        mTavernDao.deleteAll()
    }

    suspend fun deleteAllTavernInfo(){
        mTavernInfoDao.deleteAll()
    }

    fun getOneTavernbyID(id: Int) : LiveData<Tavern> {
        return mTavernDao.getOneTavern(id)
    }

    fun getOneTavernInfobyID(id: Int) : LiveData<TavernInfo> {
        return mTavernInfoDao.getOneInfo(id)
    }

    fun getLastOneTavern() : LiveData<TavernInfo> {
        return mTavernInfoDao.getOneInfo()
    }

    suspend fun updateTavern (mTavern: Tavern){
        mTavernDao.updateOne(mTavern)
    }

    suspend fun updateTavernInfo (mTavernInfo: TavernInfo){
        mTavernInfoDao.updateOne(mTavernInfo)
    }
}
