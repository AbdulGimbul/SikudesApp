package com.kerjapraktik.group.kutamandarakanapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        supportActionBar?.elevation = 0f
        supportActionBar?.title = "Profil Desa"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

}