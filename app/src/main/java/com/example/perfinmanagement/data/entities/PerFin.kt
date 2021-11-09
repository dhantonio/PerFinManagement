package com.example.perfinmanagement.data.entities

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "PerFin")
class PerFin(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String
) : Parcelable