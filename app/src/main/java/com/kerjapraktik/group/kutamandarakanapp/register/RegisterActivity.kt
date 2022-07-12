package com.kerjapraktik.group.kutamandarakanapp.register

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kerjapraktik.group.kutamandarakanapp.R
import com.kerjapraktik.group.kutamandarakanapp.login.LoginActivity
import com.kerjapraktik.group.kutamandarakanapp.register.presenter.RegisterPresenter
import com.kerjapraktik.group.kutamandarakanapp.register.presenter.RegisterView
import kotlinx.android.synthetic.main.activity_signup.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.startActivity

class RegisterActivity : AppCompatActivity(), RegisterView {
    private lateinit var presenter: RegisterPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        presenter = RegisterPresenter(this)
        btnRegister?.onClick {
            val username = edt_regisuname.text.toString()
            val email = edt_regisemail.text.toString()
            val password = edt_regispasswd.text.toString()

            presenter.register(username, email, password)

            supportActionBar?.elevation = 0f
        }
    }

    override fun onSuccessRegister(msg: String?) {
        alert {
            title = "Information Register"
            message = "Success Register"
        }.show()
        finish()
        startActivity<LoginActivity>()
    }

    override fun onFailedRegister(msg: String?) {
        alert {
            title = "Information Register"
            message = msg.toString()
        }.show()
    }
}