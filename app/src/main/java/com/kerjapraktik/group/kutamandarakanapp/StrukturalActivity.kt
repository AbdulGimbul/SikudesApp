package com.kerjapraktik.group.kutamandarakanapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kerjapraktik.group.kutamandarakanapp.adapter.DataAparaturAdapter
import com.kerjapraktik.group.kutamandarakanapp.model.AparaturItem
import com.kerjapraktik.group.kutamandarakanapp.model.DataItem
import com.kerjapraktik.group.kutamandarakanapp.model.NoteItem
import com.kerjapraktik.group.kutamandarakanapp.presenter.CrudView
import com.kerjapraktik.group.kutamandarakanapp.presenter.StrukturalPresenter
import kotlinx.android.synthetic.main.activity_aparatur.*
import kotlinx.android.synthetic.main.activity_master.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.startActivity

class StrukturalActivity : AppCompatActivity(), CrudView {
    private lateinit var strukturalPresenter: StrukturalPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aparatur)
        strukturalPresenter = StrukturalPresenter(this)
        strukturalPresenter.getAparatur()

        btnAddAparatur.setOnClickListener {
            startActivity<AparaturAddUpdateActivity>()
            finish()
        }

        supportActionBar?.elevation = 0f
        supportActionBar?.title = "Data Aparatur Desa"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSuccessGetAparatur(data: List<AparaturItem>?) {
        rv_aparatur.adapter = DataAparaturAdapter(data, object : DataAparaturAdapter.onClickItem{
            override fun clicked(item: AparaturItem?) {
                startActivity<AparaturAddUpdateActivity>("dataItem" to item)
            }

            override fun delete(item: AparaturItem?) {
                strukturalPresenter.deleteAparatur(item?.aparaturNipd)
                startActivity<MasterActivity>()
                finish()
            }
        })
    }

    override fun onSuccessGetNote(data: List<NoteItem>?) {
        //TODO
    }


    override fun onSuccessGet(data: List<DataItem>?) {
    }

    override fun onFailedGet(msg: String) {
    }

    override fun onSuccessDelete(msg: String) {
        strukturalPresenter.getAparatur()
    }

    override fun onErrorDelete(msg: String) {
        alert {
            title = "Error Delete Data"
        }.show()
    }

    override fun successAdd(msg: String) {
    }

    override fun errordAdd(msg: String) {
    }

    override fun onSuccessUpdate(msg: String) {
    }

    override fun onErrorUpdate(msg: String) {
    }

}