package com.kerjapraktik.group.kutamandarakanapp.dashboard

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.SearchView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.kerjapraktik.group.kutamandarakanapp.alarm.AlarmActivity
import com.kerjapraktik.group.kutamandarakanapp.*
import com.kerjapraktik.group.kutamandarakanapp.login.LoginActivity
import kotlinx.android.synthetic.main.activity_dashboard.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.startActivity

class DashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        toMasterData.onClick {
            startActivity<MasterActivity>()
        }

        toKlasifikasi.onClick {
            startActivity<KlasifikasiActivity>()
        }

        toProfilDesa.onClick {
            val intentProfil = Intent(this@DashboardActivity, ProfileActivity::class.java)
            startActivity(intentProfil)
        }

        toNoteData.onClick {
            val intentNote = Intent(this@DashboardActivity, NotesActivity::class.java)
            startActivity(intentNote)
        }

        toPengingat.onClick {
            val intentPengingat = Intent(this@DashboardActivity, AlarmActivity::class.java)
            startActivity(intentPengingat)
        }

        toStrukturalDesa.onClick {
            val intentStruktural = Intent(this@DashboardActivity, StrukturalActivity::class.java)
            startActivity(intentStruktural)
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.logout -> { startActivity<LoginActivity>()
            finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}