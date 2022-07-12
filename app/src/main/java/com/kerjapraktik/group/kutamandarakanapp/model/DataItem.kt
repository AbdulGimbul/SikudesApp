package com.kerjapraktik.group.kutamandarakanapp.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class DataItem : Serializable {
    @field:SerializedName("nik")
    val pendudukNik: String? = null
    @field:SerializedName("no_kk")
    val pendudukKK: String? = null
    @field:SerializedName("nama")
    val pendudukName: String? = null
    @field:SerializedName("tempat_lahir")
    val pendudukLahir: String? = null
    @field:SerializedName("tgl_lahir")
     val pendudukTglLahir: String? = null
    @field:SerializedName("jk")
    val pendudukJk: String? = null
    @field:SerializedName("alamat")
    val pendudukAddress: String? = null
    @field:SerializedName("agama")
    val pendudukReligion: String? = null
    @field:SerializedName("status")
    val pendudukStatus: String? = null
    @field:SerializedName("pekerjaan")
    val pendudukPekerjaan: String? = null
    @field:SerializedName("goldar")
    val pendudukGoldar: String? = null
}