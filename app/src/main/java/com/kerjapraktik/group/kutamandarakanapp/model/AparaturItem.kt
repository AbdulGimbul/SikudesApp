package com.kerjapraktik.group.kutamandarakanapp.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable


class AparaturItem : Serializable {
    @field:SerializedName("nipd")
    val aparaturNipd: String? = null
    @field:SerializedName("nama")
    val aparaturNama: String? = null
    @field:SerializedName("jabatan")
    val aparaturJabatan: String? = null
    @field:SerializedName("pendidikan")
    val aparaturPendidikan: String? = null
    @field:SerializedName("tmt")
    val aparaturTmt: String? = null
    @field:SerializedName("jk")
    val aparaturJk: String? = null
}