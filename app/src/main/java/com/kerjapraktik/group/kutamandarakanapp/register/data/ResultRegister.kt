package com.kerjapraktik.group.kutamandarakanapp.register.data

import com.google.gson.annotations.SerializedName

data class ResultRegister(
        @field:SerializedName("message")
        val message: String? = null,

        @field:SerializedName("status")
        val status: Int? = null
)