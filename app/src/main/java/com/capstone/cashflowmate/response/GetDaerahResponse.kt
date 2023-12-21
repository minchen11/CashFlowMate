package com.capstone.cashflowmate.response

import com.google.gson.annotations.SerializedName

data class GetDaerahResponse(

	@field:SerializedName("GetDaerahResponse")
	val getDaerahResponse: List<GetDaerahResponseItem?>? = null
)

data class GetDaerahResponseItem(

	@field:SerializedName("nama_daerah")
	val namaDaerah: String? = null,

	@field:SerializedName("updated_at")
	val updatedAt: String? = null,

	@field:SerializedName("id_daerah")
	val idDaerah: String? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("umr")
	val umr: Int? = null
)
