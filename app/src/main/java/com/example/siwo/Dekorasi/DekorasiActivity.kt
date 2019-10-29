package com.example.siwo.Dekorasi

import ApiMain
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.siwo.Adapter.AdapterDekorasi
import com.example.siwo.R
import com.example.siwo.Response.Dekorasi
import kotlinx.android.synthetic.main.activity_dekorasi.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DekorasiActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dekorasi)

        viewManager = LinearLayoutManager(this)

        btnTambahDekorasi.setOnClickListener{
            startActivity(Intent(this, TambahDekorasiActivity::class.java))
        }

        ApiMain().services.getDekorasi().enqueue(object: Callback<ArrayList<Dekorasi>> {
            override fun onResponse(call: Call<ArrayList<Dekorasi>>, response: Response<ArrayList<Dekorasi>>) {
                viewAdapter = AdapterDekorasi(response.body())
                recyclerView= findViewById<RecyclerView>(R.id.rvDekorasi).apply {
                    setHasFixedSize(true)
                    layoutManager=viewManager
                    adapter=viewAdapter
                }
            }
            override fun onFailure(call: Call<ArrayList<Dekorasi>>, t: Throwable) {
                Toast.makeText(this@DekorasiActivity, t.message, Toast.LENGTH_SHORT).show()
            }
        })
    }
}
