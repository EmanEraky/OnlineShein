package com.eman.onlineshein.presentation.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.eman.onlineshein.R
import com.eman.onlineshein.databinding.ActivityDetailsBinding
import com.eman.onlineshein.databinding.RowSliderBinding
import com.eman.onlineshein.domain.models.GalleryPhoto
import com.eman.onlineshein.domain.models.Review
import com.eman.onlineshein.presentation.listeners.GalleryListener
import com.eman.onlineshein.utils.ResultStatus
import com.eman.onlineshein.utils.setImageUrl
import com.synnapps.carouselview.ViewListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsActivity : AppCompatActivity(), GalleryListener {
    lateinit var binding: ActivityDetailsBinding
    private lateinit var reviewAdapter: ReviewAdapter
    private lateinit var imagesAdapter: ImagesAdapter
    var productId = 0
    private val detailViewModel: DetailViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_details)
        productId = intent.getIntExtra("productId", 0)
        reviewAdapter = ReviewAdapter(arrayListOf())
        imagesAdapter = ImagesAdapter(arrayListOf(), this)
        binding.reviewAdapter = reviewAdapter
        binding.imagesAdapter = imagesAdapter

        detailViewModel.getDetailResponse(productId)
        setObserveDetail()
    }

    private fun setObserveDetail() {
        detailViewModel.detailsProduct.observe(this, Observer {
            when (it) {
                is ResultStatus.Success -> {
                    binding.progressBar.visibility = View.GONE
                    it.data.let { res ->
                        binding.products = res.data.Products
                        renderReviewList(res.data.Products.review)
                        renderGalleyList(res.data.Products.Gallary)
                        if (res.data.Products.Gallary.size > 0)
                            setImageUrl(binding.imgSlide, res.data.Products.Gallary[0].images)
                    }
                    binding.recyclerReview.visibility = View.VISIBLE
                }
                is ResultStatus.Error -> {
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(this, it.exception, Toast.LENGTH_LONG).show()
                }
                is ResultStatus.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                    binding.recyclerReview.visibility = View.GONE
                }
            }
        })
    }


    private fun renderGalleyList(gallery: MutableList<GalleryPhoto>) {
        imagesAdapter.addData(gallery)
        imagesAdapter.notifyDataSetChanged()
    }

    private fun renderReviewList(lReview: MutableList<Review>) {
        reviewAdapter.addData(lReview)
        reviewAdapter.notifyDataSetChanged()
    }

    override fun onClickPhoto(path: String) {
        setImageUrl(binding.imgSlide, path)
    }

    override fun onDestroy() {
        super.onDestroy()
        finish()
    }
}