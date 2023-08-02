package com.example.ejercico5modulo6.data

import com.example.ejercico5modulo6.data.remote.Terreno
import com.example.ejercico5modulo6.data.remote.TerrenoAPI

class Repositorio(private val terrenoAPI: TerrenoAPI) {
    suspend fun cargarTerreno(): List<Terreno>{
        return terrenoAPI.getData()
    }
}