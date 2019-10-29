package com.example.siwo.Response

import com.google.gson.annotations.SerializedName

data class Respon(

	@SerializedName("response")
	val response: Int? = null,

	@SerializedName("message")
	val message: String? = null
)