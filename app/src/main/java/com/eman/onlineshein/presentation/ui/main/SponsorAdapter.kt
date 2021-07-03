package com.eman.onlineshein.presentation.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.eman.onlineshein.R
import com.eman.onlineshein.databinding.RowSponserBinding
import com.eman.onlineshein.domain.models.Sponsors

class SponsorAdapter(private var sponsers: MutableList<Sponsors>) :
    RecyclerView.Adapter<SponsorAdapter.DataViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val binding = DataBindingUtil.inflate<RowSponserBinding>(
            LayoutInflater.from(parent.context),
            R.layout.row_sponser,
            parent,
            false
        )
        return DataViewHolder(binding)
    }

    override fun getItemCount(): Int = sponsers.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.binding.sponsor = sponsers.get(position)
    }

    class DataViewHolder(val binding: RowSponserBinding) : RecyclerView.ViewHolder(binding.root)

    fun addData(list: MutableList<Sponsors>) {
        sponsers=(list)
    }


}