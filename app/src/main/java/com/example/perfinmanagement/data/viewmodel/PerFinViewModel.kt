package com.example.perfinmanagement.data.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.perfinmanagement.data.database.PerFinDatabase
import com.example.perfinmanagement.data.entities.PerFin
import com.example.perfinmanagement.data.repository.PerFinRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PerFinViewModel(application: Application) : AndroidViewModel(application){
    val readAllPerFin: LiveData<List<PerFin>>
    private val repository: PerFinRepository

    init {
        val productDao = PerFinDatabase.getDatabase(application).PerFinDao()
        repository = PerFinRepository(productDao)
        readAllPerFin = repository.readAllPerFin
    }

    fun  addPerFin(product: PerFin){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addProduct(product)
        }
    }

    fun updatePerFin(PerFin: PerFin) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateProduct(PerFin)
        }
    }

    fun  deletePerFin(PerFin: PerFin) {
        viewModelScope.launch(Dispatchers.IO) {
        }
    }
}
