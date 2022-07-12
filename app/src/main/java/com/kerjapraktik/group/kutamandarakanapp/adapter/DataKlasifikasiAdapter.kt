package com.kerjapraktik.group.kutamandarakanapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.kerjapraktik.group.kutamandarakanapp.R
import com.kerjapraktik.group.kutamandarakanapp.model.DataItem
import kotlinx.android.synthetic.main.item_data.view.*
import kotlinx.android.synthetic.main.item_data.view.img_item_photo
import kotlinx.android.synthetic.main.item_data.view.tv_item_name
import kotlinx.android.synthetic.main.item_row_data.view.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class DataKlasifikasiAdapter (val data: List<DataItem>?) : RecyclerView.Adapter<DataKlasifikasiAdapter.DataViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataKlasifikasiAdapter.DataViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_row_data, parent, false)
        return DataViewHolder(view)
    }

    override fun onBindViewHolder(holder: DataKlasifikasiAdapter.DataViewHolder, position: Int) {
            holder.onBind(data?.get(position))

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
        fun onBind(get: DataItem?){
            with(itemView) {
                    tv_item_name_row.text = get?.pendudukName
                    tv_item_address_row.text = get?.pendudukAddress
                    if (get?.pendudukJk == "Perempuan") {
                        Glide.with(context)
                            .load(R.drawable.user_female)
                            .apply(RequestOptions().override(55, 55))
                            .into(img_item_photo_row)
                    } else {
                        Glide.with(context)
                            .load(R.drawable.user)
                            .apply(RequestOptions().override(55, 55))
                            .into(img_item_photo_row)
                    }
            }
        }
    }
}