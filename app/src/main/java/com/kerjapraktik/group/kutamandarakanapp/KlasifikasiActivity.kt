package com.kerjapraktik.group.kutamandarakanapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kerjapraktik.group.kutamandarakanapp.klasifikasi.DetailKlasGoldarActivity
import com.kerjapraktik.group.kutamandarakanapp.klasifikasi.DetailKlasJkActivity
import com.kerjapraktik.group.kutamandarakanapp.klasifikasi.DetailKlasPekerjaanActivity
import com.kerjapraktik.group.kutamandarakanapp.klasifikasi.DetailKlasStatusActivity
import com.kerjapraktik.group.kutamandarakanapp.model.AparaturItem
import com.kerjapraktik.group.kutamandarakanapp.model.DataItem
import com.kerjapraktik.group.kutamandarakanapp.model.NoteItem
import com.kerjapraktik.group.kutamandarakanapp.presenter.CrudView
import com.kerjapraktik.group.kutamandarakanapp.presenter.Presenter
import kotlinx.android.synthetic.main.activity_klasifikasi.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.startActivity

class KlasifikasiActivity : AppCompatActivity(), CrudView {

    private lateinit var presenter: Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_klasifikasi)
        presenter = Presenter(this)

        btn_klas_jk.onClick {
            startActivity<DetailKlasJkActivity>()
        }

        btn_klas_status.onClick {
            val intentStatus = Intent(this@KlasifikasiActivity, DetailKlasStatusActivity::class.java)
            startActivity(intentStatus)
        }

        btn_klas_pekerjaan.onClick {
            val intentPekerjaan = Intent(this@KlasifikasiActivity, DetailKlasPekerjaanActivity::class.java)
            startActivity(intentPekerjaan)
        }

        btn_klas_goldar.onClick {
            val intentGoldar = Intent(this@KlasifikasiActivity, DetailKlasGoldarActivity::class.java)
            startActivity(intentGoldar)
        }

        supportActionBar?.elevation = 0f
        supportActionBar?.title = "Klasifikasi Penduduk"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        presenter.getData()
    }

    override fun onSuccessGetAparatur(data: List<AparaturItem>?) {
        TODO("Not yet implemented")
    }

    override fun onSuccessGetNote(data: List<NoteItem>?) {
        TODO("Not yet implemented")
    }

    override fun onSuccessGet(data: List<DataItem>?) {
        jml_penduduk?.text = "${data?.size.toString()} Orang"
    }

    override fun onFailedGet(msg: String) {
        TODO("Not yet implemented")
    }

    override fun onSuccessDelete(msg: String) {
        TODO("Not yet implemented")
    }

    override fun onErrorDelete(msg: String) {
        TODO("Not yet implemented")
    }

    override fun successAdd(msg: String) {
        TODO("Not yet implemented")
    }

    override fun errordAdd(msg: String) {
        TODO("Not yet implemented")
    }

    override fun onSuccessUpdate(msg: String) {
        TODO("Not yet implemented")
    }

    override fun onErrorUpdate(msg: String) {
        TODO("Not yet implemented")
    }
}