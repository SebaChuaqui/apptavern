package com.example.apptavern.model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class TavernViewModel(application: Application): AndroidViewModel(application) {

    private val mRepository: TavernRepository
    val mAllTavern: LiveData<List<Tavern>>
    val mAllTavernInfo: LiveData<List<TavernInfo>>

    init {
        val mTavernDao = DataBaseTavern.getDataBase(application).getTavernDao()
        val mTavernInfoDao = DataBaseTavern.getDataBase(application).getTavernInfo()

        mRepository = TavernRepository(mTavernDao, mTavernInfoDao)
        mAllTavern = mRepository.mListAllTavern
        mAllTavernInfo = mRepository.mListAllTavernInfo

    }

    fun insertTavern(mTavern: Tavern) = viewModelScope.launch {
        mRepository.insertTavern(mTavern)
    }

    fun insertTavernInfo(mTavernInfo: TavernInfo) = viewModelScope.launch {
        mRepository.insertTavernInfo(mTavernInfo)
    }

    fun deleteAllTavern() = viewModelScope.launch {
        mRepository.deleteAllTavern()
    }

    fun deleteAllTavernInfo() = viewModelScope.launch {
        mRepository.deleteAllTavernInfo()
    }

    fun getOneTavernByID(id: Int): LiveData<Tavern> {
        return mRepository.getOneTavernbyID(id)
    }

    fun getOneTavernInfoByID(id: Int): LiveData<TavernInfo> {
        return mRepository.getOneTavernInfobyID(id)
    }

    fun getLastOneTavern(): LiveData<TavernInfo> {
        return mRepository.getLastOneTavern()
    }

    fun updateTavern(mTavern: Tavern) = viewModelScope.launch {
        mRepository.updateTavern(mTavern)
    }

    fun updateTavernInfo(mTavernInfo: TavernInfo) = viewModelScope.launch {
        mRepository.updateTavernInfo(mTavernInfo)
    }

}
