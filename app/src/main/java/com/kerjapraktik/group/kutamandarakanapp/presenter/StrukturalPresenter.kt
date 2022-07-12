package com.kerjapraktik.group.kutamandarakanapp.presenter

import android.util.Log
import com.kerjapraktik.group.kutamandarakanapp.model.ResultAparatur
import com.kerjapraktik.group.kutamandarakanapp.model.ResultStatus
import com.kerjapraktik.group.kutamandarakanapp.network.NetworkConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class StrukturalPresenter(val crudView: CrudView) {
    //Fungsi get data
    fun getAparatur(){
        NetworkConfig.getService().getAparatur()
            .enqueue(object : Callback<ResultAparatur> {
                override fun onFailure(call: Call<ResultAparatur>, t: Throwable) {
                    crudView.onFailedGet(t.localizedMessage)
                    Log.d("Error", "Error Data")
                }

                override fun onResponse(call: Call<ResultAparatur>, response: Response<ResultAparatur>) {
                    if (response.isSuccessful){
                        val status = response.body()?.status
                        if (status == 200){
                            val data = response.body()?.aparatur
                            crudView.onSuccessGetAparatur(data)
                        } else {
                            crudView.onFailedGet("Error $status")
                        }
                    }
                }
            })
    }


    //Add data
    fun addAparatur(nama: String, jabatan: String, pendidikan: String, tmt: String, jk: String){
        NetworkConfig.getService()
            .addAparatur(nama, jabatan, pendidikan, tmt, jk)
            .enqueue(object : Callback<ResultStatus> {
                override fun onFailure(call: Call<ResultStatus>, t: Throwable) {
                    crudView.errordAdd(t.localizedMessage)
                }

                override fun onResponse(call: Call<ResultStatus>, response: Response<ResultStatus>) {
                    if (response.isSuccessful && response.body()?.status == 200){
                        crudView.successAdd(response.body()?.pesan ?: "")
                    } else {
                        crudView.errordAdd(response.body()?.pesan ?: "")
                    }
                }
            })
    }

    //Hapus data
    fun deleteAparatur(nipd: String?){
        NetworkConfig.getService()
            .deletePenduduk(nipd)
            .enqueue(object : Callback<ResultStatus> {
                override fun onFailure(call: Call<ResultStatus>, t: Throwable) {
                    crudView.onErrorDelete(t.localizedMessage)
                }

                override fun onResponse(call: Call<ResultStatus>, response: Response<ResultStatus>) {
                    if (response.isSuccessful && response.body()?.status == 200){
                        crudView.onSuccessDelete(response.body()?.pesan ?: "")
                    } else {
                        crudView.onErrorDelete(response.body()?.pesan ?: "")
                    }
                }
            })
    }

    //Update data
    fun updateAparatur(nipd: String, nama: String, jabatan: String, pendidikan: String, tmt: String, jk: String) {
        NetworkConfig.getService()
            .updateAparatur(nipd, nama, jabatan, pendidikan, tmt, jk)
            .enqueue(object : Callback<ResultStatus> {
                override fun onFailure(call: Call<ResultStatus>, t: Throwable) {
                    crudView.onErrorUpdate(t.localizedMessage)
                }

                override fun onResponse(call: Call<ResultStatus>, response: Response<ResultStatus>) {
                    if (response.isSuccessful && response.body()?.status == 200){
                        crudView.onSuccessUpdate(response.body()?.pesan ?: "")
                    } else {
                        crudView.onErrorUpdate(response.body()?.pesan ?: "")
                    }
                }
            })
    }
}