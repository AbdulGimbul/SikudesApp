package com.kerjapraktik.group.kutamandarakanapp.presenter

import com.kerjapraktik.group.kutamandarakanapp.model.AparaturItem
import com.kerjapraktik.group.kutamandarakanapp.model.DataItem
import com.kerjapraktik.group.kutamandarakanapp.model.NoteItem

interface CrudView {
    //Untuk get data
    fun onSuccessGetAparatur(data: List<AparaturItem>?)
    fun onSuccessGetNote(data: List<NoteItem>?)
    fun onSuccessGet(data: List<DataItem>?)
    fun onFailedGet(msg: String)

    //Untuk delete
    fun onSuccessDelete(msg: String)
    fun onErrorDelete(msg: String)

    //Untuk add
    fun successAdd(msg: String)
    fun errordAdd(msg: String)

    //Untuk update
    fun onSuccessUpdate(msg: String)
    fun onErrorUpdate(msg: String)
}