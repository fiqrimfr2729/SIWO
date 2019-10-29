package com.example.siwo.Response


import com.google.gson.annotations.SerializedName

data class Dekorasi(

	@field:SerializedName("foto")
	val foto: String?,

	@field:SerializedName("nama_dekorasi")
	val namaDekorasi: String? ,

	@field:SerializedName("deskripsi")
	val deskripsi: String? ,

	@field:SerializedName("harga_dekorasi")
	val hargaDekorasi: Int?,

	@field:SerializedName("dekorasi_id")
	val dekorasiId: String?
)