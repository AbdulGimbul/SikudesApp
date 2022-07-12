package com.kerjapraktik.group.kutamandarakanapp.klasifikasi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kerjapraktik.group.kutamandarakanapp.R
import com.kerjapraktik.group.kutamandarakanapp.adapter.PekerjaanPagerAdapter
import kotlinx.android.synthetic.main.activity_detail_clas_pekerjaan.*

class DetailKlasPekerjaanActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_clas_pekerjaan)

        val pekerjaanPagerAdapter = PekerjaanPagerAdapter(this, supportFragmentManager)
        view_pager_pekerjaan.adapter = pekerjaanPagerAdapter

        tabs_pekerjaan.setupWithViewPager(view_pager_pekerjaan)

        supportActionBar?.elevation = 0f
        supportActionBar?.title = "Berdasarkan Pekerjaan"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}