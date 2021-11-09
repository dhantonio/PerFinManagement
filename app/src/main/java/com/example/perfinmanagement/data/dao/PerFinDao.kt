package com.example.perfinmanagement.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.perfinmanagement.data.entities.PerFin

@Dao
interface PerFinDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addPerFin(product: PerFin)

    @Update
    fun updatePerFin(product: PerFin)

    @Query("SELECT * FROM PerFin ORDER BY id DESC")
    fun readAllPerFin(): LiveData<List<PerFin>>

    @Delete
    fun deletePerFin(product: PerFin)
}
