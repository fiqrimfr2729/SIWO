package com.example.siwo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.siwo.Dekorasi.DekorasiActivity
import com.example.siwo.Gedung.GedungActivity
import com.example.siwo.Rias.RiasActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnDekorasi.setOnClickListener{
            startActivity(Intent(this, DekorasiActivity::class.java))
        }

        btnGedung.setOnClickListener{
            startActivity(Intent(this, GedungActivity::class.java))
        }

        btnRias.setOnClickListener{
            startActivity(Intent(this, RiasActivity::class.java))
        }
    }


}
