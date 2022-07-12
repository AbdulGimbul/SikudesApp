package com.kerjapraktik.group.kutamandarakanapp.presenter

import android.util.Log
import com.kerjapraktik.group.kutamandarakanapp.model.DataItem
import com.kerjapraktik.group.kutamandarakanapp.model.ResultPenduduk
import com.kerjapraktik.group.kutamandarakanapp.model.ResultStatus
import com.kerjapraktik.group.kutamandarakanapp.network.NetworkConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Presenter (val crudView: CrudView) {
    //Fungsi get data
    fun getData() {
        NetworkConfig.getService().getData()
            .enqueue(object : Callback<ResultPenduduk> {
                override fun onFailure(call: Call<ResultPenduduk>, t: Throwable) {
                    crudView.onFailedGet(t.localizedMessage)
                    Log.d("Error", "Error Data")
                }

                override fun onResponse(
                    call: Call<ResultPenduduk>,
                    response: Response<ResultPenduduk>
                ) {
                    if (response.isSuccessful) {
                        val status = response.body()?.status
                        if (status == 200) {
                            val data = response.body()?.penduduk
                            crudView.onSuccessGet(data)
                        } else {
                            crudView.onFailedGet("Error $status")
                        }
                    }
                }
            })
    }


    //Add data
    fun addData(nik: String, no_kk: String, nama: String, tempat_lahir: String, tgl_lahir: String, jk: String, alamat: String, agama: String, status: String, pekerjaan: String, goldar: String){
        NetworkConfig.getService()
                .addPenduduk(nik, no_kk, nama, tempat_lahir, tgl_lahir, jk, alamat, agama, status, pekerjaan, goldar)
                .enqueue(object : Callback<ResultStatus>{
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
    fun hapusData(nik: String?){
        NetworkConfig.getService()
                .deletePenduduk(nik)
                .enqueue(object : Callback<ResultStatus>{
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
    fun updateData(nik: String, no_kk: String, nama: String, tempat_lahir: String, tgl_lahir: String, jk: String, alamat: String, agama: String, status: String, pekerjaan: String, goldar: String) {
        NetworkConfig.getService()
                .updatePenduduk(nik, no_kk, nama, tempat_lahir, tgl_lahir, jk, alamat, agama, status, pekerjaan, goldar)
                .enqueue(object : Callback<ResultStatus>{
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

    fun fetchPenduduk(keyword: String?){
        NetworkConfig.getService()
            .fetchPenduduk(keyword)
            .enqueue(object : Callback<ResultPenduduk> {
                override fun onFailure(call: Call<ResultPenduduk>, t: Throwable) {
                    crudView.onFailedGet(t.localizedMessage)
                    Log.d("Error", "Error Data")
                }

                override fun onResponse(call: Call<ResultPenduduk>, response: Response<ResultPenduduk>) {
                    if (response.isSuccessful) {
                        val data = response.body()?.penduduk
                        crudView.onSuccessGet(data)
                    } else {
                        crudView.onFailedGet("Error")
                    }
                }
            })
    }
}