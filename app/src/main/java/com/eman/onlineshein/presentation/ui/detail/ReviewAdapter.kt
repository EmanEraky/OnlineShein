package com.eman.onlineshein.presentation.ui.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.eman.onlineshein.R
import com.eman.onlineshein.databinding.RowReviewBinding
import com.eman.onlineshein.databinding.RowVendorBinding
import com.eman.onlineshein.domain.models.Review
import com.eman.onlineshein.domain.models.Vendors

class ReviewAdapter(
    private var review: MutableList<Review>
) :
    RecyclerView.Adapter<ReviewAdapter.DataViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val binding = DataBindingUtil.inflate<RowReviewBinding>(
            LayoutInflater.from(parent.context),
            R.layout.row_review,
            parent,
            false
        )
        return DataViewHolder(binding)
    }

    override fun getItemCount(): Int = review.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.binding.review = review.get(position)
    }

    class DataViewHolder(val binding: RowReviewBinding) : RecyclerView.ViewHolder(binding.root)

    fun addData(list: MutableList<Review>) {
        review=(list)
    }


}