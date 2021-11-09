package com.example.perfinmanagement.data.repository

import androidx.lifecycle.LiveData
import com.example.perfinmanagement.data.dao.PerFinDao
import com.example.perfinmanagement.data.entities.PerFin

class PerFinRepository(private val PerFinDao: PerFinDao) {
    val readAllPerFin : LiveData<List<PerFin>> = PerFinDao.readAllPerFin()

    suspend fun addProduct(product: PerFin){
        PerFinDao.addPerFin(product)
    }

    suspend fun updateProduct(product: PerFin) {
        PerFinDao.updatePerFin(product)
    }

    suspend fun deleteProduct(product: PerFin) {
        PerFinDao.deletePerFin(product)
    }
}
