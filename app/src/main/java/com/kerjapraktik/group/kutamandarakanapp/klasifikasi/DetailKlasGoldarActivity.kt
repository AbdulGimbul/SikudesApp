package com.kerjapraktik.group.kutamandarakanapp.klasifikasi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kerjapraktik.group.kutamandarakanapp.R
import com.kerjapraktik.group.kutamandarakanapp.adapter.GoldarPagerAdapter
import com.kerjapraktik.group.kutamandarakanapp.model.AparaturItem
import com.kerjapraktik.group.kutamandarakanapp.model.DataItem
import com.kerjapraktik.group.kutamandarakanapp.model.NoteItem
import com.kerjapraktik.group.kutamandarakanapp.presenter.CrudView
import com.kerjapraktik.group.kutamandarakanapp.presenter.KlasifikasiGoldar
import kotlinx.android.synthetic.main.activity_detail_clas_goldar.*

class DetailKlasGoldarActivity : AppCompatActivity(), CrudView {
    private lateinit var klasifikasiGoldar: KlasifikasiGoldar
    private lateinit var rekapGoldar: RekapGoldar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_clas_goldar)

        val goldarPagerAdapter = GoldarPagerAdapter(this, supportFragmentManager)
        view_pager_goldar.adapter = goldarPagerAdapter
        tabs_goldar.setupWithViewPager(view_pager_goldar)
        klasifikasiGoldar = KlasifikasiGoldar(this)

        supportActionBar?.elevation = 0f
        supportActionBar?.title = "Berdasarkan Golongan Darah"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        klasifikasiGoldar.getGoldarA()

    }

    override fun onSuccessGetAparatur(data: List<AparaturItem>?) {
        TODO("Not yet implemented")
    }

    override fun onSuccessGetNote(data: List<NoteItem>?) {
        TODO("Not yet implemented")
    }

    override fun onSuccessGet(data: List<DataItem>?) {
        jumlah_a.text = "${data?.size.toString()} Orang fix"
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
