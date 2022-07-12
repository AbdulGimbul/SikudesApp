package com.kerjapraktik.group.kutamandarakanapp.model

import com.google.gson.annotations.SerializedName

data class ResultAparatur (
    @field:SerializedName("pesan")
    val pesan: String? = null,

    @field:SerializedName("aparatur")
    val aparatur: List<AparaturItem>? = null,

    @field:SerializedName("status")
    val status: Int? = null
)