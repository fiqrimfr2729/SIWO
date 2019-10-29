package com.example.siwo


import androidx.annotation.Keep
import com.example.siwo.Response.Dekorasi
import com.example.siwo.Response.Gedung
import com.example.siwo.Response.Respon
import com.example.siwo.Response.Rias

import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.DELETE
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.PartMap
import retrofit2.http.Query


interface ApiServices {

    @FormUrlEncoded
    @POST("login")
    fun login(@Field("username") username: String?,
              @Field("password") password: String?): Call<Respon>

    @Keep
    @GET("dekorasi")
    fun getDekorasi(): Call<ArrayList<Dekorasi>>

    @Keep
    @GET("gedung")
    fun getGedung(): Call<ArrayList<Gedung>>

    @Keep
    @GET("rias")
    fun getRias(): Call<ArrayList<Rias>>

    @Multipart
    @POST("addDekorasi")
    fun addDekorasi(@Query("nama_dekorasi") namaDekorasi: String,
                    @Query("harga_dekorasi") hargaDekorasi: String,
                    @Query("deskripsi") deskripsi: String,
                    @Part filefoto1: MultipartBody.Part): Call<Respon>
}