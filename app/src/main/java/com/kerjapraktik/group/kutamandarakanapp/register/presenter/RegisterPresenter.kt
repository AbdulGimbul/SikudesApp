package com.kerjapraktik.group.kutamandarakanapp.register.presenter

import com.kerjapraktik.group.kutamandarakanapp.network.NetworkConfig
import com.kerjapraktik.group.kutamandarakanapp.register.data.ResultRegister
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterPresenter (val registerView: RegisterView) {
    fun register (username: String?, email: String?, password: String?){
        NetworkConfig.getService()
                .register(username, email, password)
                .enqueue(object : Callback<ResultRegister> {
                    override fun onFailure(call: Call<ResultRegister>, t: Throwable) {
                        registerView.onFailedRegister(t.localizedMessage)
                    }

                    override fun onResponse(call: Call<ResultRegister>, response: Response<ResultRegister>) {
                        if (response.body()?.status == 200){
                            registerView.onSuccessRegister(response.body()?.message)
                        }else{
                            registerView.onFailedRegister(response.body()?.message)
                        }
                    }
                })
    }
}