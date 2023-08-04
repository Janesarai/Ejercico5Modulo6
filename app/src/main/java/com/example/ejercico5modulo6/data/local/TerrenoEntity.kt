package com.example.ejercico5modulo6.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "tabla_terreno")
data class TerrenoEntity(    @PrimaryKey val id: String,
                             val precio: Int,
                             val tipo: String,
                             val imagen: String)
