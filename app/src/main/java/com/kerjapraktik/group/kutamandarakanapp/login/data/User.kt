package com.kerjapraktik.group.kutamandarakanapp.login.data

import com.google.gson.annotations.SerializedName

data class User (
    @field:SerializedName("user_id")
    val userId: String? = null,

    @field:SerializedName("username")
    val mUsername: String? = null,

    @field:SerializedName("email")
    val mEmail: String? = null,

    @field:SerializedName("password")
    val mPassword: String? = null
)