package com.eman.onlineshein.presentation.ui.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.eman.onlineshein.R
import com.eman.onlineshein.databinding.RowImgBinding
import com.eman.onlineshein.domain.models.GalleryPhoto
import com.eman.onlineshein.presentation.listeners.GalleryListener

class ImagesAdapter(private var photes: MutableList<GalleryPhoto>, private var listener: GalleryListener) :
    RecyclerView.Adapter<ImagesAdapter.DataViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val binding = DataBindingUtil.inflate<RowImgBinding>(
            LayoutInflater.from(parent.context),
            R.layout.row_img,
            parent,
            false
        )
        return DataViewHolder(binding)
    }

    override fun getItemCount(): Int = photes.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.binding.galleryListener = listener
        holder.binding.gallery = photes.get(position)
    }

    class DataViewHolder(val binding: RowImgBinding) : RecyclerView.ViewHolder(binding.root)

    fun addData(list: MutableList<GalleryPhoto>) {
        photes = (list)
    }

}