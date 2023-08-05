package com.example.ejercico5modulo6.presentacion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import coil.load
import com.example.ejercico5modulo6.R
import com.example.ejercico5modulo6.databinding.FragmentDetalleBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "id"


/**
 * A simple [Fragment] subclass.
 * Use the [FragmentDetalle.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentDetalle : Fragment() {
    private lateinit var binding: FragmentDetalleBinding
    private val terrenosVM: TerrenosVM by activityViewModels()

    private var param1: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)

        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
      binding = FragmentDetalleBinding.inflate(layoutInflater,container,false)
        terrenosVM.terrenooLiveData(param1.toString()).observe(viewLifecycleOwner){
            binding.txID.text = it.id
            binding.txTipo.text = it.tipo
            binding.txPrecio.text = it.precio.toString()
            binding.imageView.load(it.imagen)
        }
         return binding.root
    }

}