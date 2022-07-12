package com.kerjapraktik.group.kutamandarakanapp.model

import com.google.gson.annotations.SerializedName

data class ResultNote (
    @field:SerializedName("pesan")
    val pesan: String? = null,

    @field:SerializedName("note")
    val note: List<NoteItem>? = null,

    @field:SerializedName("status")
    val status: Int? = null
)