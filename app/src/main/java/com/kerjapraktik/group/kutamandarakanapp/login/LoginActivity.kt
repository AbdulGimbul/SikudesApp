package com.kerjapraktik.group.kutamandarakanapp.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kerjapraktik.group.kutamandarakanapp.PendudukActivity
import com.kerjapraktik.group.kutamandarakanapp.R
import com.kerjapraktik.group.kutamandarakanapp.dashboard.DashboardActivity
import com.kerjapraktik.group.kutamandarakanapp.login.data.User
import com.kerjapraktik.group.kutamandarakanapp.login.presenter.LoginPresenter
import com.kerjapraktik.group.kutamandarakanapp.login.presenter.LoginView
import com.kerjapraktik.group.kutamandarakanapp.register.RegisterActivity
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.startActivity

class LoginActivity : AppCompatActivity(), LoginView {
    private lateinit var presenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        presenter = LoginPresenter(this)

        btnLogin.onClick {
            val email = login_email.text.toString()
            val password = login_password.text.toString()
            presenter.login(email, password)
        }

        btnToRegister.onClick {
            startActivity<RegisterActivity>()
        }

        btnToPenduduk.onClick {
            startActivity<PendudukActivity>()
        }
    }

    override fun onSuccessLogin(msg: String?, data: User?) {
        alert {
            title = "Information"
            message = "Login Success"
        }.show()
        startActivity<DashboardActivity>()
        finish()
    }

    override fun onFailedLogin(msg: String?) {
        alert {
            title = "Information"
            message = "Login failed, silahkan cek email dan password"
        }.show()
    }
}