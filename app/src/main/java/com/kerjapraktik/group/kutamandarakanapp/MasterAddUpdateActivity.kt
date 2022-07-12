package com.kerjapraktik.group.kutamandarakanapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.kerjapraktik.group.kutamandarakanapp.model.AparaturItem
import com.kerjapraktik.group.kutamandarakanapp.model.DataItem
import com.kerjapraktik.group.kutamandarakanapp.model.NoteItem
import com.kerjapraktik.group.kutamandarakanapp.presenter.CrudView
import com.kerjapraktik.group.kutamandarakanapp.presenter.Presenter
import kotlinx.android.synthetic.main.activity_master_add_update.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.startActivity

@Suppress("SENSELESS_COMPARISON")
class MasterAddUpdateActivity : AppCompatActivity(), CrudView {

    private lateinit var presenter: Presenter
    @SuppressLint("SetText18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_master_add_update)

        presenter = Presenter(this)
        val itemDataItem = intent.getSerializableExtra("dataItem")

        val status = resources.getStringArray(R.array.status)
        val spinner = findViewById<Spinner>(R.id.spinnerStatus)
        if (spinner != null){
            val adapter = ArrayAdapter(this,
                android.R.layout.simple_spinner_dropdown_item, status)
            spinner.adapter = adapter

            spinner.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener{
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    edt_status.text = status[position]
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }
            }

        }

        if (itemDataItem == null) {
            btn_submit.text = "Tambah"
            btn_submit.onClick {
                presenter.addData(
                    edt_nik.text.toString(),
                    edt_nokk.text.toString(),
                    edt_nama.text.toString(),
                    edt_lahir.text.toString(),
                    edt_tgl_lahir.text.toString(),
                    edt_jk.text.toString(),
                    edt_alamat.text.toString(),
                    edt_agama.text.toString(),
                    edt_status.text.toString(),
                    edt_pekerjaan.text.toString(),
                    edt_goldar.text.toString()
                )
            }
        } else if (itemDataItem != null) {
            btn_submit.text = "Update"
            val item = itemDataItem as DataItem?
            edt_nik.setText(item?.pendudukNik.toString())
            edt_nokk.setText(item?.pendudukKK.toString())
            edt_nama.setText(item?.pendudukName.toString())
            edt_lahir.setText(item?.pendudukLahir.toString())
            edt_tgl_lahir.setText(item?.pendudukTglLahir.toString())
            edt_jk.setText(item?.pendudukJk.toString())
            edt_alamat.setText(item?.pendudukAddress.toString())
            edt_agama.setText(item?.pendudukReligion.toString())
            edt_status.setText(item?.pendudukStatus.toString())
            edt_pekerjaan.setText(item?.pendudukPekerjaan.toString())
            edt_goldar.setText(item?.pendudukGoldar.toString())
            btn_submit.onClick {
                presenter.updateData(
                    item?.pendudukNik ?: "",
                    edt_nokk.text.toString(),
                    edt_nama.text.toString(),
                    edt_lahir.text.toString(),
                    edt_tgl_lahir.text.toString(),
                    edt_jk.text.toString(),
                    edt_alamat.text.toString(),
                    edt_agama.text.toString(),
                    edt_status.text.toString(),
                    edt_pekerjaan.text.toString(),
                    edt_goldar.text.toString()
                )
                finish()
            }
        }
    }

    override fun successAdd(msg: String) {
        startActivity<MasterActivity>()
        finish()
    }

    override fun errordAdd(msg: String) {
    }

    override fun onSuccessUpdate(msg: String) {
        startActivity<MasterActivity>()
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