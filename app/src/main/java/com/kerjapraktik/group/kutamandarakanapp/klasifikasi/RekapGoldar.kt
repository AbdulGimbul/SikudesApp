package com.kerjapraktik.group.kutamandarakanapp.klasifikasi

import com.kerjapraktik.group.kutamandarakanapp.model.AparaturItem
import com.kerjapraktik.group.kutamandarakanapp.model.DataItem
import com.kerjapraktik.group.kutamandarakanapp.model.NoteItem
import com.kerjapraktik.group.kutamandarakanapp.presenter.CrudView
import com.kerjapraktik.group.kutamandarakanapp.presenter.KlasifikasiGoldar
import kotlinx.android.synthetic.main.activity_detail_clas_goldar.*

class RekapGoldar: CrudView {

    private lateinit var klasifikasiGoldar: KlasifikasiGoldar


    override fun onSuccessGetAparatur(data: List<AparaturItem>?) {
        TODO("Not yet implemented")
    }

    override fun onSuccessGetNote(data: List<NoteItem>?) {
        TODO("Not yet implemented")
    }


    override fun onSuccessGet(data: List<DataItem>?) {
        "${data?.size.toString()} Orang fix"
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