package com.example.ejercico5modulo6.presentacion

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.ejercico5modulo6.data.Repositorio
import com.example.ejercico5modulo6.data.local.TerrenoDatabase
import com.example.ejercico5modulo6.data.remote.Terreno
import com.example.ejercico5modulo6.data.remote.TerrenoRetroFit
import kotlinx.coroutines.launch

class TerrenosVM( application: Application): AndroidViewModel (application) {
    private val repositorio: Repositorio
    fun terrenoLiveData() = repositorio.obtenerAllTerrenos()

    init {
        val api = TerrenoRetroFit.getTerrenoRetrofit()
        val terrenoDatabase = TerrenoDatabase.getDataBase(application).getITerrenoDao()
        repositorio = Repositorio(api, terrenoDatabase)

    }

    fun getObtenerTerrenos() = viewModelScope.launch {
         repositorio.cargarTerreno()
    }
    fun terrenooLiveData(id:String) = repositorio.getTerreno(id)
}