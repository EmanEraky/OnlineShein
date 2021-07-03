package com.eman.onlineshein.presentation.ui.main

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.eman.onlineshein.R
import com.eman.onlineshein.databinding.RowDiscountBinding
import com.eman.onlineshein.domain.models.RecommendStatus
import com.eman.onlineshein.presentation.listeners.NavigationListener

class DiscountAdapter(private var products: MutableList<RecommendStatus>, private var listener: NavigationListener) :
    RecyclerView.Adapter<DiscountAdapter.DataViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val binding = DataBindingUtil.inflate<RowDiscountBinding>(
            LayoutInflater.from(parent.context),
            R.layout.row_discount,
            parent,
            false
        )
        return DataViewHolder(binding)
    }

    override fun getItemCount(): Int = products.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.binding.navigationListener = listener
        holder.binding.txtDiscount.paintFlags =
            holder.binding.txtDiscount.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        holder.binding.discount = products.get(position)
    }

    class DataViewHolder(val binding: RowDiscountBinding) : RecyclerView.ViewHolder(binding.root)

    fun addData(list: MutableList<RecommendStatus>) {
        products = (list)
    }


}