package com.example.siwo.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.recyclerview.widget.RecyclerView
import com.example.siwo.R
import com.example.siwo.Response.Rias
import kotlinx.android.synthetic.main.list_rias.view.*

class AdapterRias (private val myDataSet : ArrayList<Rias>? ):
    RecyclerView.Adapter<AdapterRias.MyViewHolder>() {
    val listRias = myDataSet


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterRias.MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_rias, parent, false)
        return AdapterRias.MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listRias!!.size
    }

    override fun onBindViewHolder(holder: AdapterRias.MyViewHolder, position: Int) {
        holder.view.tvNamaRias.setText(listRias?.get(position)?.namaRias)
        holder.view.tvHargaRias.setText(listRias?.get(position)?.hargaRias)
    }

    class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view)

}