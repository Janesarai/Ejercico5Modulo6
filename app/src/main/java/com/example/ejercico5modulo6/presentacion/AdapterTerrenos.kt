package com.example.ejercico5modulo6.presentacion

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.ejercico5modulo6.data.local.TerrenoEntity
import com.example.ejercico5modulo6.data.remote.Terreno
import com.example.ejercico5modulo6.databinding.ItemTerrenoBinding



class AdapterTerrenos: RecyclerView.Adapter<AdapterTerrenos.ItemTerrenoViewHolder>() {
    lateinit var binding: ItemTerrenoBinding
    private val listadoItemTerrenos = mutableListOf<TerrenoEntity>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemTerrenoViewHolder {
       binding = ItemTerrenoBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ItemTerrenoViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listadoItemTerrenos.size
    }

    override fun onBindViewHolder(holder: ItemTerrenoViewHolder, position: Int) {
        val terreno = listadoItemTerrenos[position]
        holder.bind(terreno)
    }
    fun setData(terreno: List<TerrenoEntity>){
        this.listadoItemTerrenos.clear()
        this.listadoItemTerrenos.addAll(terreno)
        notifyDataSetChanged()
    }

    class ItemTerrenoViewHolder(val v: ItemTerrenoBinding):RecyclerView.ViewHolder(v.root) {
        fun bind(terreno: TerrenoEntity){
            v.imgTerrenos.load(terreno.imagen)
        }

    }
}