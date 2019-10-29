package com.example.siwo

import ApiMain
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.siwo.Response.Respon
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnLogin.setOnClickListener(){
            val username = etUsername.text.toString()
            val password = etPassword.text.toString()

            ApiMain().services.login(username, password).enqueue(object :
                Callback<Respon> {
                override fun onResponse(call: Call<Respon>, response: Response<Respon>) {
                    //Tulis code jika response sukses
                    if(response.body()?.response == 1){
                        startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                    }else{
                        Toast.makeText(this@LoginActivity, "Username atau password salah", Toast.LENGTH_SHORT).show()
                    }
                }
                override fun onFailure(call: Call<Respon>, t: Throwable){
                    Toast.makeText(this@LoginActivity, t.message, Toast.LENGTH_SHORT).show()
                }
            })

        }

    }
}
