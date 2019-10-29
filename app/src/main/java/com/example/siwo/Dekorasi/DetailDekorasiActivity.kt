package com.example.siwo.Dekorasi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.siwo.R
import kotlinx.android.synthetic.main.activity_detail_dekorasi.*

class DetailDekorasiActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_dekorasi)

        val namaDekorasi = intent.getStringExtra("nama")
        val harga = intent.getStringExtra("harga")
        val deskripsi = intent.getStringExtra("deskripsi")
        val foto = intent.getStringArrayExtra("foto")

        tvNamaDekorasiDetail.setText(namaDekorasi)
        tvHargaDekorasiDetail.setText(harga)
        tvDeskripsiDekorasiDetail.setText(deskripsi)

    }
}
