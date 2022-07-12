package com.kerjapraktik.group.kutamandarakanapp

import android.app.SearchManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.SearchView
import com.kerjapraktik.group.kutamandarakanapp.adapter.DataAdapter
import com.kerjapraktik.group.kutamandarakanapp.model.AparaturItem
import com.kerjapraktik.group.kutamandarakanapp.model.DataItem
import com.kerjapraktik.group.kutamandarakanapp.model.NoteItem
import com.kerjapraktik.group.kutamandarakanapp.presenter.CrudView
import com.kerjapraktik.group.kutamandarakanapp.presenter.Presenter
import kotlinx.android.synthetic.main.activity_master.*
import kotlinx.android.synthetic.main.item_data.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.startActivity

class MasterActivity : AppCompatActivity(), CrudView {
    private lateinit var presenter: Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_master)
        presenter = Presenter(this)
        presenter.getData()

        btnAdd.setOnClickListener {
            startActivity<MasterAddUpdateActivity>()
            finish()
        }

        supportActionBar?.elevation = 0f
        supportActionBar?.title = "Data Penduduk"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSuccessGet(data: List<DataItem>?) {
        rv_penduduk.adapter = DataAdapter(data, object : DataAdapter.onClickItem{
            override fun clicked(item: DataItem?) {
                startActivity<MasterAddUpdateActivity>("dataItem" to item)
            }

            override fun delete(item: DataItem?) {
                presenter.hapusData(item?.pendudukNik)
                startActivity<MasterActivity>()
                finish()
            }
        })

    }

    override fun onSuccessGetAparatur(data: List<AparaturItem>?) {
        TODO("Not yet implemented")
    }

    override fun onSuccessGetNote(data: List<NoteItem>?) {
        //TODO
    }


    override fun onFailedGet(msg: String) {
    }

    override fun onSuccessDelete(msg: String) {
        presenter.getData()
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.toolbar_menu, menu)

        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchView = menu?.findItem(R.id.search)?.actionView as SearchView

        searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName))
        searchView.queryHint = "Cari penduduk desa"
        searchView.isIconifiedByDefault = false
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                presenter.fetchPenduduk(query)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })
        return true

    }
}