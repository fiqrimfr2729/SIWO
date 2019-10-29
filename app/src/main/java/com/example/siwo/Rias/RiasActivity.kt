package com.example.siwo.Rias

import ApiMain
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.siwo.Adapter.AdapterGedung
import com.example.siwo.Adapter.AdapterRias
import com.example.siwo.R
import com.example.siwo.Response.Gedung
import com.example.siwo.Response.Rias
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RiasActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rias)

        viewManager = LinearLayoutManager(this)

        val call = ApiMain().services.getRias()
        call.enqueue(object : Callback<ArrayList<Rias>> {
            override fun onFailure(call: Call<ArrayList<Rias>>, t: Throwable) {
                Toast.makeText(this@RiasActivity, t.message, Toast.LENGTH_SHORT)
            }

            override fun onResponse(
                call: Call<ArrayList<Rias>>,
                response: Response<ArrayList<Rias>>
            ) {
                viewAdapter= AdapterRias(response.body())
                recyclerView=findViewById<RecyclerView>(R.id.rvRias).apply{
                    setHasFixedSize(true)
                    layoutManager=viewManager
                    adapter=viewAdapter
                }
            }

        })
    }
}
