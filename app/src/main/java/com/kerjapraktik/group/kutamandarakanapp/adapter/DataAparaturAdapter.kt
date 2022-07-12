package com.kerjapraktik.group.kutamandarakanapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.kerjapraktik.group.kutamandarakanapp.R
import com.kerjapraktik.group.kutamandarakanapp.model.AparaturItem
import kotlinx.android.synthetic.main.item_aparatur.view.*
import kotlinx.android.synthetic.main.item_data.view.*
import kotlinx.android.synthetic.main.item_data.view.tv_item_name
import org.jetbrains.anko.sdk27.coroutines.onClick

class DataAparaturAdapter (val data: List<AparaturItem>?, private val click: onClickItem) : RecyclerView.Adapter<DataAparaturAdapter.DataViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DataAparaturAdapter.DataViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_aparatur, parent, false)
        return DataViewHolder(view)
    }

    override fun onBindViewHolder(holder: DataAparaturAdapter.DataViewHolder, position: Int) {
        holder.onBind(data?.get(position))
        holder.itemView.onClick {
            click.clicked(data?.get(position))
        }

        holder.itemView.btnRemoveAparatur.setOnClickListener {
            click.delete(data?.get(position))
        }
    }

    override fun getItemCount(): Int {
        return data?.size ?: 0
    }


    inner class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun onBind(get: AparaturItem?) {
            with(itemView) {
                tv_item_name.text = get?.aparaturNama
                tv_item_pendidikan.text = get?.aparaturPendidikan
                tv_item_tmt.text = get?.aparaturTmt
                btn_set_jabatan.text = get?.aparaturJabatan
                if (get?.aparaturJk == "Perempuan") {
                    Glide.with(context)
                        .load(R.drawable.user_female)
                        .apply(RequestOptions().override(55, 55))
                        .into(img_item_photo_aparatur)
                } else {
                    Glide.with(context)
                        .load(R.drawable.user)
                        .apply(RequestOptions().override(55, 55))
                        .into(img_item_photo_aparatur)
                }
            }
        }
    }

    interface onClickItem {
        fun clicked(item: AparaturItem?)
        fun delete(item: AparaturItem?)
    }
}