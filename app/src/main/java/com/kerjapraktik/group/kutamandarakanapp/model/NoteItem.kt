package com.kerjapraktik.group.kutamandarakanapp.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class NoteItem : Serializable {
    @field:SerializedName("id")
    val noteId: String? = null

    @field:SerializedName("judul")
    val noteJudul: String? = null

    @field:SerializedName("deskripsi")
    val noteDeskripsi: String? = null

    @field:SerializedName("tanggal")
    val noteTanggal: String? = null
}