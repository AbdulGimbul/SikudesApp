package com.kerjapraktik.group.kutamandarakanapp.presenter

import android.util.Log
import com.kerjapraktik.group.kutamandarakanapp.model.ResultNote
import com.kerjapraktik.group.kutamandarakanapp.model.ResultStatus
import com.kerjapraktik.group.kutamandarakanapp.network.NetworkConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NotePresenter (val crudView: CrudView) {
    fun getNote(){
        NetworkConfig.getService().getNote()
            .enqueue(object : Callback<ResultNote>{
                override fun onFailure(call: Call<ResultNote>, t: Throwable) {
                    crudView.onFailedGet(t.localizedMessage)
                    Log.d("Error", "Error Data")
                }

                override fun onResponse(call: Call<ResultNote>, response: Response<ResultNote>) {
                    if (response.isSuccessful){
                        val status = response.body()?.status
                        if (status == 200){
                            val data = response.body()?.note
                            crudView.onSuccessGetNote(data)
                        } else {
                            crudView.onFailedGet("Error $status")
                        }
                    }
                }
            })
    }

    fun addNote(judul : String, deskripsi: String, tanggal: String){
        NetworkConfig.getService()
            .addNote(judul, deskripsi, tanggal)
            .enqueue(object : Callback<ResultStatus>{
                override fun onFailure(call: Call<ResultStatus>, t: Throwable) {
                    crudView.errordAdd(t.localizedMessage)
                }

                override fun onResponse(
                    call: Call<ResultStatus>,
                    response: Response<ResultStatus>
                ) {
                    if (response.isSuccessful && response.body()?.status == 200){
                        crudView.successAdd(response.body()?.pesan ?: "")
                    } else {
                        crudView.errordAdd(response.body()?.pesan ?: "")
                    }
                }
            })
    }

    fun deleteNote(id: String?){
        NetworkConfig.getService()
            .deleteNote(id)
            .enqueue(object : Callback<ResultStatus>{
                override fun onFailure(call: Call<ResultStatus>, t: Throwable) {
                    crudView.onErrorDelete(t.localizedMessage)
                }

                override fun onResponse(
                    call: Call<ResultStatus>,
                    response: Response<ResultStatus>
                ) {
                    if (response.isSuccessful && response.body()?.status == 200) {
                        crudView.onSuccessDelete(response.body()?.pesan ?: "")
                    } else {
                        crudView.onErrorDelete(response.body()?.pesan ?: "")
                    }
                }
            })
    }

    fun updateNote(id: String, judul : String, deskripsi: String, tanggal: String){
        NetworkConfig.getService()
            .updateNote(id, judul, deskripsi, tanggal)
            .enqueue(object : Callback<ResultStatus>{
                override fun onFailure(call: Call<ResultStatus>, t: Throwable) {
                    crudView.onErrorUpdate(t.localizedMessage)
                }

                override fun onResponse(
                    call: Call<ResultStatus>,
                    response: Response<ResultStatus>
                ) {
                    if (response.isSuccessful && response.body()?.status == 200){
                        crudView.onSuccessUpdate(response.body()?.pesan ?: "")
                    } else {
                        crudView.onErrorUpdate(response.body()?.pesan ?: "")
                    }
                }
            })
    }
}