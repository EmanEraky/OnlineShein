package com.eman.onlineshein.presentation.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.eman.onlineshein.R
import com.eman.onlineshein.databinding.RowVendorBinding
import com.eman.onlineshein.domain.models.Vendors

class VendorAdapter(
    private var vendors: MutableList<Vendors>
) :
    RecyclerView.Adapter<VendorAdapter.DataViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val binding = DataBindingUtil.inflate<RowVendorBinding>(
            LayoutInflater.from(parent.context),
            R.layout.row_vendor,
            parent,
            false
        )
        return DataViewHolder(binding)
    }

    override fun getItemCount(): Int = vendors.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.binding.vendor = vendors.get(position)
    }

    class DataViewHolder(val binding: RowVendorBinding) : RecyclerView.ViewHolder(binding.root)

    fun addData(list: MutableList<Vendors>) {
        vendors=(list)
    }


}