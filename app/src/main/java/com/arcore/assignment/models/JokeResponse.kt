package com.arcore.assignment.models

import com.google.gson.annotations.SerializedName

data class JokeResponse(

	@field:SerializedName("icon_url")
	val iconUrl: String? = null,

	@field:SerializedName("updated_at")
	val updatedAt: String? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("categories")
	val categories: List<Any?>? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("value")
	val value: String? = null,

	@field:SerializedName("url")
	val url: String? = null
)
