package com.example.siwo.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.siwo.Gedung.GedungDetailActivity
import com.example.siwo.R
import com.example.siwo.Response.Dekorasi
import kotlinx.android.synthetic.main.list_dekorasi.view.*

class AdapterDekorasi(private val Mydataset: ArrayList<Dekorasi>? ):RecyclerView.Adapter<AdapterDekorasi.MyViewHolder>(){
    private val listDekorasi : ArrayList<Dekorasi>? = Mydataset

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AdapterDekorasi.MyViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.list_dekorasi, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        if (listDekorasi != null) {
            return listDekorasi.size
        }
        return 0
    }

    override fun onBindViewHolder(holder: AdapterDekorasi.MyViewHolder, position: Int) {
        holder.view.tvNamaDekorasi.setText(listDekorasi?.get(position)?.namaDekorasi)
        holder.view.tvHargaDekorasi.setText("Rp. "+listDekorasi?.get(position)?.hargaDekorasi.toString())

        holder.view.setOnClickListener{
            val intent = Intent(holder.view.context, GedungDetailActivity::class.java)
            intent.putExtra("nama", listDekorasi?.get(position)?.namaDekorasi)
            intent.putExtra("harga", listDekorasi?.get(position)?.hargaDekorasi)
            intent.putExtra("deskripsi", listDekorasi?.get(position)?.deskripsi)
            intent.putExtra("foto", listDekorasi?.get(position)?.foto)
            holder.view.context.startActivity(intent)
        }
    }

    class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view)

}