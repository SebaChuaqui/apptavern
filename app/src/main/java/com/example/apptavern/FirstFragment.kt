package com.example.apptavern

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.apptavern.DataBaseTavern.Tavern
import kotlinx.android.synthetic.main.fragment_first.*

class FirstFragment : Fragment() {

    lateinit var mViewModel: TavernViewModel
    private var idTavern: Int? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel = ViewModelProvider(this).get(TavernViewModel::class.java)
        arguments?.let {
            idTavern = it.getInt("id")
            Log.d("OBJ", idTavern.toString())
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        idTavern?.let {
            mViewModel.getOneTaskByID(it).observe(viewLifecycleOwner, Observer {
                Producto.setText(it.product)
                Precio.value(it.price)
                Cantidad.value(it.quantity)
            })


            button_second.setOnClickListener() {
                var textTavern1 = Producto.text.toString()
                var textTavern2 = Precio.value
                var textTavern3 = Cantidad.value

                if (idTavern != null) {
                    Log.d("OBJ_ID_TASK", idTavern.toString())
                    var mTavern = Tavern(0, textTavern1, textTavern2, textTavern3)
                    mViewModel.updateTavern(mTavern)
                } else {
                    if (textTavern1.isNotEmpty()) {
                        var mTavern = Tavern(0, textTavern1, textTavern2, textTavern3)
                        mViewModel.updateTavern(mTavern)
                    }
                }
                findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
            }
        }
    }
}

