package com.example.ejercico5modulo6.presentacion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.ejercico5modulo6.R
import com.example.ejercico5modulo6.databinding.FragmentListadoTerrenoBinding


class ListadoTerreno : Fragment() {
    lateinit var binding: FragmentListadoTerrenoBinding
    private val terrenosVM: TerrenosVM by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListadoTerrenoBinding.inflate(layoutInflater,container,false)
        initAdapter()
        binding.btnCargar.setOnClickListener {
            terrenosVM.getObtenerTerrenos()
        }
        return binding.root
    }
    private fun initAdapter(){
        terrenosVM.getObtenerTerrenos()
        val adapter = AdapterTerrenos()
        binding.RV.adapter = adapter
        terrenosVM.terrenoLiveData().observe(viewLifecycleOwner){
            adapter.setData(it)
        }
    }



}