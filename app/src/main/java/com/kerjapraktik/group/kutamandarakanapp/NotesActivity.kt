package com.kerjapraktik.group.kutamandarakanapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kerjapraktik.group.kutamandarakanapp.adapter.NoteAdapter
import com.kerjapraktik.group.kutamandarakanapp.model.AparaturItem
import com.kerjapraktik.group.kutamandarakanapp.model.DataItem
import com.kerjapraktik.group.kutamandarakanapp.model.NoteItem
import com.kerjapraktik.group.kutamandarakanapp.presenter.CrudView
import com.kerjapraktik.group.kutamandarakanapp.presenter.NotePresenter
import kotlinx.android.synthetic.main.activity_notes.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.startActivity

class NotesActivity : AppCompatActivity(), CrudView {

    private lateinit var notePresenter: NotePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notes)
        notePresenter = NotePresenter(this)
        notePresenter.getNote()

        btnAddNote.onClick {
            val intentAdd = Intent(this@NotesActivity, NoteAddUpdateActivity::class.java)
            startActivity(intentAdd)
        }

        supportActionBar?.elevation = 0f
        supportActionBar?.title = "Catatan Kecil"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSuccessGetAparatur(data: List<AparaturItem>?) {
        TODO("Not yet implemented")
    }

    override fun onSuccessGetNote(data: List<NoteItem>?) {
        rv_notes.adapter = NoteAdapter(data, object : NoteAdapter.onClickItem{
            override fun clicked(item: NoteItem?) {
                startActivity<NoteAddUpdateActivity>("dataItem" to item)
            }

            override fun delete(item: NoteItem?) {
                notePresenter.deleteNote(item?.noteId)
                startActivity<NotesActivity>()
                finish()
            }
        })
    }

    override fun onSuccessGet(data: List<DataItem>?) {
        TODO("Not yet implemented")
    }

    override fun onFailedGet(msg: String) {
    }

    override fun onSuccessDelete(msg: String) {
        notePresenter.getNote()
    }

    override fun onErrorDelete(msg: String) {
        alert {
            title = "Error Delete Data"
        }.show()
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