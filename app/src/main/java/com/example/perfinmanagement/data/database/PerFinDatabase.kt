package com.example.perfinmanagement.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.perfinmanagement.data.dao.PerFinDao
import com.example.perfinmanagement.data.entities.PerFin

@Database(entities = [PerFin :: class], version = 1, exportSchema = false)
abstract class PerFinDatabase : RoomDatabase() {

    abstract fun PerFinDao() : PerFinDao
    companion object {
        @Volatile
        private var INSTANCE: PerFinDatabase? = null

        fun getDatabase(context: Context): PerFinDatabase{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PerFinDatabase::class.java,
                    "PerFin_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}