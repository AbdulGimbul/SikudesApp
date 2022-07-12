package com.kerjapraktik.group.kutamandarakanapp.presenter

import android.util.Log
import com.kerjapraktik.group.kutamandarakanapp.model.ResultPenduduk
import com.kerjapraktik.group.kutamandarakanapp.network.NetworkConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class KlasifikasiPekerjaan (val crudView: CrudView) {
    fun getKerjaWiraswasta(){
        NetworkConfig.getService().getKerjaWiraswasta()
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

    fun getKerjaGuru(){
        NetworkConfig.getService().getKerjaGuru()
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

    fun getKerjaPNS(){
        NetworkConfig.getService().getKerjaPNS()
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

    fun getKerjaTani(){
        NetworkConfig.getService().getKerjaTani()
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


    fun getKerjaKaryawan(){
        NetworkConfig.getService().getKerjaKaryawan()
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