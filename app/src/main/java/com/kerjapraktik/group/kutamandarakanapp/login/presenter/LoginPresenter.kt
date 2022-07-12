package com.kerjapraktik.group.kutamandarakanapp.login.presenter

import com.kerjapraktik.group.kutamandarakanapp.login.data.ResultLogin
import com.kerjapraktik.group.kutamandarakanapp.network.NetworkConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginPresenter (val loginView: LoginView) {
    fun login(email: String, password: String){
        NetworkConfig.getService()
            .login(email, password)
            .enqueue(object : Callback<ResultLogin>{
                override fun onFailure(call: Call<ResultLogin>, t: Throwable) {
                    loginView.onFailedLogin(t.localizedMessage)
                }

                override fun onResponse(call: Call<ResultLogin>, response: Response<ResultLogin>) {
                    if (response.isSuccessful && response.body()?.status == 200){
                        loginView.onSuccessLogin(response.body()?.message, response.body()?.user)
                    }else{
                        loginView.onFailedLogin(response.body()?.message)
                    }
                }
            })
    }
}