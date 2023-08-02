package com.example.ejercico5modulo6.data.remote

import com.google.gson.annotations.SerializedName
// se mantiene los nombres de la appi pero el ultimo se cambia con serialize name porque no cumple con las conecniones de Kotlin
data class Terreno(
    val id: String,
    val price: Int,
    val type: String,
    @SerializedName("img_src") val img: String
)
