package com.kerjapraktik.group.kutamandarakanapp.presenter

import android.util.Log
import com.kerjapraktik.group.kutamandarakanapp.model.ResultPenduduk
import com.kerjapraktik.group.kutamandarakanapp.network.NetworkConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class KlasifikasiStatus(val crudView: CrudView) {
    fun getStatusLajang(){
        NetworkConfig.getService().getStatusLajang()
            .enqueue(object : Callback<ResultPenduduk> {
                override fun onFailure(call: Call<ResultPenduduk>, t: Throwable) {
                    crudView.onFailedGet(t.localizedMessage)
                    Log.d("Error", "Error Data")
                }

                override fun onResponse(call: Call<ResultPenduduk>, response: Response<ResultPenduduk>) {
                    if (response.isSuccessful){
                        val status = response.body()?.status
                        if (status == 200){
                            val data = response.body()?.penduduk
                            crudView.onSuccessGet(data)
                        } else {
                            crudView.onFailedGet("Error $status")
                        }
                    }
                }
            })
    }

    fun getStatusMenikah(){
        NetworkConfig.getService().getStatusMenikah()
            .enqueue(object : Callback<ResultPenduduk> {
                override fun onFailure(call: Call<ResultPenduduk>, t: Throwable) {
                    crudView.onFailedGet(t.localizedMessage)
                    Log.d("Error", "Error Data")
                }

                override fun onResponse(call: Call<ResultPenduduk>, response: Response<ResultPenduduk>) {
                    if (response.isSuccessful){
                        val status = response.body()?.status
                        if (status == 200){
                            val data = response.body()?.penduduk
                            crudView.onSuccessGet(data)
                        } else {
                            crudView.onFailedGet("Error $status")
                        }
                    }
                }
            })
    }

    fun getStatusCerai(){
        NetworkConfig.getService().getStatusCerai()
            .enqueue(object : Callback<ResultPenduduk> {
                override fun onFailure(call: Call<ResultPenduduk>, t: Throwable) {
                    crudView.onFailedGet(t.localizedMessage)
                    Log.d("Error", "Error Data")
                }

                override fun onResponse(call: Call<ResultPenduduk>, response: Response<ResultPenduduk>) {
                    if (response.isSuccessful){
                        val status = response.body()?.status
                        if (status == 200){
                            val data = response.body()?.penduduk
                            crudView.onSuccessGet(data)
                        } else {
                            crudView.onFailedGet("Error $status")
                        }
                    }
                }
            })
    }

    fun getStatusCeraiMati(){
        NetworkConfig.getService().getStatusCeraiMati()
            .enqueue(object : Callback<ResultPenduduk> {
                override fun onFailure(call: Call<ResultPenduduk>, t: Throwable) {
                    crudView.onFailedGet(t.localizedMessage)
                    Log.d("Error", "Error Data")
                }

                override fun onResponse(call: Call<ResultPenduduk>, response: Response<ResultPenduduk>) {
                    if (response.isSuccessful){
                        val status = response.body()?.status
                        if (status == 200){
                            val data = response.body()?.penduduk
                            crudView.onSuccessGet(data)
                        } else {
                            crudView.onFailedGet("Error $status")
                        }
                    }
                }
            })
    }
}