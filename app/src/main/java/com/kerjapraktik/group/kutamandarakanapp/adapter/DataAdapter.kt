package com.kerjapraktik.group.kutamandarakanapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.kerjapraktik.group.kutamandarakanapp.R
import com.kerjapraktik.group.kutamandarakanapp.model.DataItem
import kotlinx.android.synthetic.main.item_data.view.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class DataAdapter(val data: List<DataItem>?, private val click: onClickItem) : RecyclerView.Adapter<DataAdapter.DataViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataAdapter.DataViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_data, parent, false)
        return DataViewHolder(view)
    }

    override fun onBindViewHolder(holder: DataAdapter.DataViewHolder, position: Int) {
            holder.onBind(data?.get(position))
            holder.itemView.onClick {
                click.clicked(data?.get(position))
            }

            holder.itemView.btnRemove.setOnClickListener {
                click.delete(data?.get(position))
            }
    }

    override fun getItemCount(): Int {
        return data?.size ?: 0
    }



    inner class DataViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun onBind(get: DataItem?){
            with(itemView) {
                    tv_item_nik.text = get?.pendudukNik
                    tv_item_name.text = get?.pendudukName
                    tv_item_address.text = get?.pendudukAddress
                    if (get?.pendudukJk == "Perempuan") {
                        Glide.with(context)
                            .load(R.drawable.user_female)
                            .apply(RequestOptions().override(55, 55))
                            .into(img_item_photo)
                    } else {
                        Glide.with(context)
                            .load(R.drawable.user)
                            .apply(RequestOptions().override(55, 55))
                            .into(img_item_photo)
                    }
            }
        }
    }

    interface onClickItem {
        fun clicked(item: DataItem?)
        fun delete(item: DataItem?)
    }
}