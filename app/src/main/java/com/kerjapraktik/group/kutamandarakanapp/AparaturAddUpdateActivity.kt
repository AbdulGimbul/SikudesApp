package com.kerjapraktik.group.kutamandarakanapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kerjapraktik.group.kutamandarakanapp.model.AparaturItem
import com.kerjapraktik.group.kutamandarakanapp.model.DataItem
import com.kerjapraktik.group.kutamandarakanapp.model.NoteItem
import com.kerjapraktik.group.kutamandarakanapp.presenter.CrudView
import com.kerjapraktik.group.kutamandarakanapp.presenter.StrukturalPresenter
import kotlinx.android.synthetic.main.activity_aparatur_add_update.*
import kotlinx.android.synthetic.main.activity_master_add_update.btn_submit
import kotlinx.android.synthetic.main.activity_master_add_update.edt_jk
import kotlinx.android.synthetic.main.activity_master_add_update.edt_nama
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.startActivity

@Suppress("SENSELESS_COMPARISON")
class AparaturAddUpdateActivity : AppCompatActivity(), CrudView {

    private lateinit var strukturalPresenter: StrukturalPresenter

    @SuppressLint("SetText18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aparatur_add_update)

        strukturalPresenter = StrukturalPresenter(this)
        val itemDataItem = intent.getSerializableExtra("dataItem")

        if (itemDataItem == null) {
            btn_submit.text = "Tambah"
            btn_submit.onClick {
                strukturalPresenter.addAparatur(
                    edt_nama.text.toString(),
                    edt_jabatan.text.toString(),
                    edt_pendidikan.text.toString(),
                    edt_tmt.text.toString(),
                    edt_jk_aparatur.text.toString()
                )
            }
        } else if (itemDataItem != null) {
            btn_submit.text = "Update"
            val item = itemDataItem as AparaturItem?
            edt_nama.setText(item?.aparaturNama.toString())
            edt_jabatan.setText(item?.aparaturJabatan.toString())
            edt_pendidikan.setText(item?.aparaturPendidikan.toString())
            edt_tmt.setText(item?.aparaturTmt.toString())
            edt_jk.setText(item?.aparaturJk.toString())
            btn_submit.onClick {
                strukturalPresenter.updateAparatur(
                    item?.aparaturNipd ?: "",
                    edt_nama.text.toString(),
                    edt_jabatan.text.toString(),
                    edt_pendidikan.text.toString(),
                    edt_tmt.text.toString(),
                    edt_jk.text.toString()
                )
                finish()
            }
        }
    }

    override fun successAdd(msg: String) {
        startActivity<StrukturalActivity>()
        finish()
    }

    override fun errordAdd(msg: String) {
    }

    override fun onSuccessUpdate(msg: String) {
        startActivity<StrukturalActivity>()
        finish()
    }

    override fun onErrorUpdate(msg: String) {
    }

    override fun onSuccessGetAparatur(data: List<AparaturItem>?) {
        TODO("Not yet implemented")
    }

    override fun onSuccessGetNote(data: List<NoteItem>?) {
        TODO("Not yet implemented")
    }

    override fun onSuccessGet(data: List<DataItem>?) {
    }

    override fun onFailedGet(msg: String) {
    }

    override fun onSuccessDelete(msg: String) {
    }

    override fun onErrorDelete(msg: String) {
    }
}
