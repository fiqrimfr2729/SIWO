package com.example.siwo.Gedung

import ApiMain
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.siwo.Adapter.AdapterGedung
import com.example.siwo.R
import com.example.siwo.Response.Gedung
import kotlinx.android.synthetic.main.activity_gedung.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GedungActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gedung)

        viewManager = LinearLayoutManager(this)

        btnTambahGedung.setOnClickListener{

        }

        val call = ApiMain().services.getGedung()
        call.enqueue(object : Callback<ArrayList<Gedung>>{
            override fun onFailure(call: Call<ArrayList<Gedung>>, t: Throwable) {
                Toast.makeText(this@GedungActivity, t.message, Toast.LENGTH_SHORT)
            }

            override fun onResponse(
                call: Call<ArrayList<Gedung>>,
                response: Response<ArrayList<Gedung>>
            ) {
                viewAdapter=AdapterGedung(response.body())
                recyclerView=findViewById<RecyclerView>(R.id.rvGedung).apply{
                    setHasFixedSize(true)
                    layoutManager=viewManager
                    adapter=viewAdapter
                }
            }

        })
    }
}
