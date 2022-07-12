package com.kerjapraktik.group.kutamandarakanapp.klasifikasi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kerjapraktik.group.kutamandarakanapp.R
import com.kerjapraktik.group.kutamandarakanapp.adapter.StatusPagerAdapter
import kotlinx.android.synthetic.main.activity_detail_clas_jk.*
import kotlinx.android.synthetic.main.activity_detail_clas_status.*

class DetailKlasStatusActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_clas_status)

        val statusPagerAdapter = StatusPagerAdapter(this, supportFragmentManager)
        view_pager_status.adapter = statusPagerAdapter
        tabs_status.setupWithViewPager(view_pager_status)

        supportActionBar?.elevation = 0f
        supportActionBar?.title = "Berdasarkan Status"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}