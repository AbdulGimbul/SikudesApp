package com.kerjapraktik.group.kutamandarakanapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kerjapraktik.group.kutamandarakanapp.R
import com.kerjapraktik.group.kutamandarakanapp.model.NoteItem
import kotlinx.android.synthetic.main.item_notes.view.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class NoteAdapter (val data: List<NoteItem>?, private val click: onClickItem) : RecyclerView.Adapter<NoteAdapter.DataViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteAdapter.DataViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_notes, parent, false)
        return DataViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoteAdapter.DataViewHolder, position: Int) {
            holder.onBind(data?.get(position))
            holder.itemView.onClick {
                click.clicked(data?.get(position))
            }

            holder.itemView.btnRemoveNotes.setOnClickListener {
                click.delete(data?.get(position))
            }
    }

    override fun getItemCount(): Int {
        return data?.size ?: 0
    }

//    override fun getFilter(): Filter {
//        return filter{
//            val searchString = charS
//
//        }
//    }

    inner class DataViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun onBind(get: NoteItem?){
            with(itemView) {
                    tv_item_title.text = get?.noteJudul
                    tv_item_description.text = get?.noteDeskripsi
            }
        }
    }

    interface onClickItem {
        fun clicked(item: NoteItem?)
        fun delete(item: NoteItem?)
    }
}