package com.example.ejercico5modulo6.presentacion

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.ejercico5modulo6.data.Repositorio
import com.example.ejercico5modulo6.data.remote.Terreno
import com.example.ejercico5modulo6.data.remote.TerrenoRetroFit
import kotlinx.coroutines.launch

class TerrenosVM( application: Application): AndroidViewModel (application) {
    private val repositorio: Repositorio
    val terrenoLiveData = MutableLiveData<List<Terreno>>()

    init {
        val api = TerrenoRetroFit.getTerrenoRetrofit()
        repositorio = Repositorio(api)

    }

    fun getObtenerTerrenos() = viewModelScope.launch {
        terrenoLiveData.value = repositorio.cargarTerreno()
    }
}