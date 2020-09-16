package com.example.apptavern

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.apptavern.DataBaseTavern.Tavern
import com.example.apptavern.DataBaseTavern.TavernDataBase
import kotlinx.coroutines.launch

class TavernViewModel(application: Application): AndroidViewModel(application) {

    private var repository: TavernRepository

    var allTavern: LiveData<List<Tavern>>

    init {

        var TavernDao = TavernDataBase.getDatabase(application).getTavernDao()
        repository = TavernRepository(TavernDao)
        allTavern = repository.listAllTavern

    }

    fun insertTavern (tavern: Tavern) = viewModelScope.launch { repository.insertTavern(tavern) }

    fun deleteAllTavern() = viewModelScope.launch {
        repository.deleteAll()
    }
    // Este metodo sera observado por la vista cuando le pase el ID
    fun getOneTaskByID(id : Int): LiveData<Tavern>{
        return repository.getOneTaskByID(id)
    }
    fun updateTavern(mTavern: Tavern) = viewModelScope.launch {
        repository.updateTavern(mTavern)
    }
}