package com.kerjapraktik.group.kutamandarakanapp.login.presenter

import com.kerjapraktik.group.kutamandarakanapp.login.data.User

interface LoginView {
    fun onSuccessLogin (msg: String?, data: User?)
    fun onFailedLogin(msg: String?)
}