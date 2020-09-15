package com.example.apptavern

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.recyclerview.widget.RecyclerView
import com.example.apptavern.DataBaseTavern.Tavern
import kotlinx.android.synthetic.main.tavern_item_list.view.*

class Tavern_Adapter (var mPassTavern : PassTavern): RecyclerView.Adapter<Tavern_Adapter.TaskViewHolder>() {

    private var datalist = emptyList<Tavern>()

    fun updateList(mDataList: List<Tavern>) {
        datalist = mDataList
        notifyDataSetChanged()
    }

    inner class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        val productoText = itemView.producto
        val valorText = itemView.valor
        val cantidadText = itemView.cantidad
        val itemView = itemView.setOnClickListener(this)

        override fun onClick(p0: View?) {

            mPassTavern.passTavern(datalist[adapterPosition])
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.tavern_item_list,
            parent,
            false
        )
        return TaskViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val mPassTavern: Tavern = datalist[position]

        holder.productoText.text = mPassTavern.product
        holder.valorText.text = mPassTavern.price.toString()
        holder.cantidadText.text = mPassTavern.quantity.toString()
    }

    override fun getItemCount() = datalist.size

    interface PassTavern {
        fun passTavern(mPassTavern: Tavern)
    }
}

