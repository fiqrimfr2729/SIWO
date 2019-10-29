package com.example.siwo.Response


import com.google.gson.annotations.SerializedName

data class Rias(

	@field:SerializedName("nama_rias")
	val namaRias: String? = null,

	@field:SerializedName("harga_rias")
	val hargaRias: String? = null,

	@field:SerializedName("deskripsi")
	val deskripsi: String? = null,

	@field:SerializedName("gambar")
	val gambar: String? = null,

	@field:SerializedName("rias_id")
	val riasId: String? = null
)