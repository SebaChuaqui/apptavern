package com.example.apptavern

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_first.*
import kotlinx.android.synthetic.main.fragment_first.view.*

import kotlinx.android.synthetic.main.fragment_second.*


class SecondFragment : Fragment() {

    lateinit var mViewModel: TavernViewModel
    private var idTask: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel = ViewModelProvider(this).get(TavernViewModel::class.java)
        arguments?.let {
            idTask = it.getInt("id")
            Log.d("OBJ", idTask.toString())
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        idTask?.let {
            mViewModel.getOneTaskByID(it).observe(viewLifecycleOwner, Observer {
                Log.d("OBJ_LIV", it.product)
                Producto.setText(it.product)
                Precio.setText(it.price)
                Cantidad.setText(it.quantity)

            })

            button_second.setOnClickListener {
                var mProducto = Producto.text.toString()
                var mPrecio = Precio.text.toString()
                var mCantidad = Cantidad.text.toString()

            }
        }
    }
}

