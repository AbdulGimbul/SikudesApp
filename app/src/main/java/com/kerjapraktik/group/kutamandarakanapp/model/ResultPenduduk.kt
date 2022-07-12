package com.kerjapraktik.group.kutamandarakanapp.model

import com.google.gson.annotations.SerializedName

data class ResultPenduduk (
    @field:SerializedName("pesan")
    val pesan: String? = null,

    @field:SerializedName("penduduk")
    val penduduk: List<DataItem>? = null,

    @field:SerializedName("status")
    val status: Int? = null
)