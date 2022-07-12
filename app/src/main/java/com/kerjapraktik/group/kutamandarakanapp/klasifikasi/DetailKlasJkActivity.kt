package com.kerjapraktik.group.kutamandarakanapp.klasifikasi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kerjapraktik.group.kutamandarakanapp.R
import com.kerjapraktik.group.kutamandarakanapp.adapter.JkPagerAdapter
import kotlinx.android.synthetic.main.activity_detail_clas_jk.*

class DetailKlasJkActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_clas_jk)

        val jkPagerAdapter = JkPagerAdapter(this, supportFragmentManager)
        view_pager.adapter =jkPagerAdapter

        tabs.setupWithViewPager(view_pager)

        supportActionBar?.elevation = 0f
        supportActionBar?.title = "Berdasarkan Jenis Kelamin"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}