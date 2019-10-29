package com.example.siwo.Gedung

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.siwo.R
import kotlinx.android.synthetic.main.activity_gedung_detail.*


class GedungDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gedung_detail)

        val namaGedung = intent.getStringExtra("nama")
        val harga = intent.getStringExtra("harga")
        val deskripsi = intent.getStringExtra("deskripsi")
        val foto = intent.getStringExtra("foto")

        tvNamaGedungDetail.setText(namaGedung)
        tvHargaGedungDetail.setText(harga)
        tvDeskripsiGedungDetail.setText(deskripsi)

        if(foto!=null){
            Glide.with(this).load("http://192.168.43.217/weddingorganizer-master/uploads/$foto/1.png").into(imgGedungDetail)
        }

        Toast.makeText(this,"http://192.168.43.217/weddingorganizer-master/uploads/$foto/1.png", Toast.LENGTH_SHORT ).show()


    }
}
