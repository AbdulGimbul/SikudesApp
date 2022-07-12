package com.kerjapraktik.group.kutamandarakanapp.register.presenter

interface RegisterView {
    fun onSuccessRegister(msg: String?)
    fun onFailedRegister(msg: String?)
}