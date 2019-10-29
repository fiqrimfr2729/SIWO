package com.example.siwo.Response

import com.google.gson.annotations.SerializedName

data class Gedung(

	@field:SerializedName("gedung_id")
	val gedungId: String? = null,

	@field:SerializedName("foto")
	val foto: String? = null,

	@field:SerializedName("harga_gedung")
	val hargaGedung: String? = null,

	@field:SerializedName("deskripsi")
	val deskripsi: String? = null,

	@field:SerializedName("nama_gedung")
	val namaGedung: String? = null
)