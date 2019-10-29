package com.example.siwo.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.siwo.Gedung.GedungDetailActivity
import com.example.siwo.R
import com.example.siwo.Response.Gedung
import kotlinx.android.synthetic.main.list_gedung.view.*

class AdapterGedung(private val myDataSet: ArrayList<Gedung>? ):
    RecyclerView.Adapter<AdapterGedung.MyViewHolder>() {
    val listGedung: ArrayList<Gedung>? = myDataSet

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_gedung, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listGedung!!.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.view.tvNamaGedung.setText(listGedung?.get(position)?.namaGedung)
        holder.view.tvHargaGedung.setText(listGedung?.get(position)?.hargaGedung)

        holder.view.setOnClickListener{
            val intent = Intent(holder.view.context, GedungDetailActivity::class.java)
            intent.putExtra("nama", listGedung?.get(position)?.namaGedung)
            intent.putExtra("harga", listGedung?.get(position)?.hargaGedung)
            intent.putExtra("deskripsi", listGedung?.get(position)?.deskripsi)
            intent.putExtra("foto", listGedung?.get(position)?.foto)
            holder.view.context.startActivity(intent)
        }
    }

    class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view)
}