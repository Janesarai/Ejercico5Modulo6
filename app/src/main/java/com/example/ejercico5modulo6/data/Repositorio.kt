package com.example.ejercico5modulo6.data

import androidx.lifecycle.LiveData
import com.example.ejercico5modulo6.data.local.TerrenoDAO
import com.example.ejercico5modulo6.data.local.TerrenoEntity
import com.example.ejercico5modulo6.data.remote.Terreno
import com.example.ejercico5modulo6.data.remote.TerrenoAPI

class Repositorio(private val terrenoAPI: TerrenoAPI, private val terrenoDAO: TerrenoDAO) {

    fun obtenerAllTerrenos(): LiveData<List<TerrenoEntity>> = terrenoDAO.obtenerTerrenos()
    suspend fun cargarTerreno() {

        val respuesta = terrenoAPI.getData()
        if (respuesta.isSuccessful) {
            val resp = respuesta.body()
            resp?.let { terrenos ->
                val terrenoEntity = terrenos.map { it.transformar() }
                terrenoDAO.insertarTerrenoss(terrenoEntity)
            }
        }

    }
    fun getTerreno(id:String): LiveData<TerrenoEntity> = terrenoDAO.getTerreno(id)
}
    fun Terreno.transformar(): TerrenoEntity =
        TerrenoEntity(this.id, this.price, this.type, this.img)
