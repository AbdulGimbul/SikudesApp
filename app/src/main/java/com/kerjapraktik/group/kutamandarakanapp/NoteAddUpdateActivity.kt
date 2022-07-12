package com.kerjapraktik.group.kutamandarakanapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kerjapraktik.group.kutamandarakanapp.model.AparaturItem
import com.kerjapraktik.group.kutamandarakanapp.model.DataItem
import com.kerjapraktik.group.kutamandarakanapp.model.NoteItem
import com.kerjapraktik.group.kutamandarakanapp.presenter.CrudView
import com.kerjapraktik.group.kutamandarakanapp.presenter.NotePresenter
import kotlinx.android.synthetic.main.activity_note_add_update.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.startActivity

@Suppress("SENSELESS_COMPARISON")
class NoteAddUpdateActivity : AppCompatActivity(), CrudView {

    private lateinit var notePresenter: NotePresenter
    @SuppressLint("SetText18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_add_update)

        notePresenter = NotePresenter(this)
        val itemNoteItem = intent.getSerializableExtra("dataItem")

        if (itemNoteItem == null){
            btn_submit.text = "Tambah"
            btn_submit.onClick {
                notePresenter.addNote(
                    edt_title.text.toString(),
                    edt_description.text.toString(),
                    edt_tanggal.text.toString()
                )
            }
        } else if (itemNoteItem != null) {
            btn_submit.text = "Update"
            val item = itemNoteItem as NoteItem?
            edt_title.setText(item?.noteJudul.toString())
            edt_description.setText(item?.noteDeskripsi.toString())

            btn_submit.onClick {
                notePresenter.updateNote(
                    item?.noteId ?: "",
                    edt_title.text.toString(),
                    edt_description.text.toString(),
                    edt_tanggal.text.toString()
                )
                finish()
            }
            }
        }

    override fun onSuccessGetAparatur(data: List<AparaturItem>?) {
        TODO("Not yet implemented")
    }

    override fun onSuccessGetNote(data: List<NoteItem>?) {
        TODO("Not yet implemented")
    }

    override fun onSuccessGet(data: List<DataItem>?) {
        TODO("Not yet implemented")
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
        startActivity<NotesActivity>()
        finish()
    }

    override fun errordAdd(msg: String) {
        TODO("Not yet implemented")
    }

    override fun onSuccessUpdate(msg: String) {
        startActivity<NotesActivity>()
        finish()
    }

    override fun onErrorUpdate(msg: String) {
        TODO("Not yet implemented")
    }
}