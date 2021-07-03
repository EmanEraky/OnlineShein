package com.eman.onlineshein.presentation.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.eman.onlineshein.R
import com.eman.onlineshein.databinding.ActivityMainBinding
import com.eman.onlineshein.databinding.RowSliderBinding
import com.eman.onlineshein.domain.models.RecommendStatus
import com.eman.onlineshein.domain.models.Sliders
import com.eman.onlineshein.domain.models.Sponsors
import com.eman.onlineshein.domain.models.Vendors
import com.eman.onlineshein.presentation.listeners.NavigationListener
import com.eman.onlineshein.presentation.ui.detail.DetailsActivity
import com.eman.onlineshein.utils.ResultStatus
import com.synnapps.carouselview.ViewListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), NavigationListener {
    lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()
    private lateinit var adapter: DiscountAdapter
    private lateinit var adapterSponsor: SponsorAdapter
    private lateinit var adapterVendor: VendorAdapter

    //list for holding data
    var indexItems = mutableListOf<Sliders>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        adapterSponsor = SponsorAdapter(arrayListOf())
        adapterVendor = VendorAdapter(arrayListOf())
        adapter = DiscountAdapter(arrayListOf(), this)

        binding.vendorAdapter = adapterVendor
        binding.sponsorAdapter = adapterSponsor
        binding.mainAdapter = adapter

        binding.carouselView.pageCount = indexItems.size
        binding.carouselView.setViewListener(listener)



        setObserveProducts()
    }


    private fun setObserveProducts() {
        mainViewModel.homeData.observe(this, Observer {
            when (it) {
                is ResultStatus.Success -> {
                    binding.progressBar.visibility = View.GONE
                    it.data.let { res ->

                        indexItems.addAll(res.data.Sliders)
                        binding.carouselView.pageCount = indexItems.size
                        binding.carouselView.setViewListener(listener)


                        renderSponsorList(res.data.Sponsors)
                        renderVendorList(res.data.vendor)
                        renderList(res.data.recommend_paid_status)
                    }
                    binding.recyclerView.visibility = View.VISIBLE
                }
                is ResultStatus.Error -> {
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(this, it.exception, Toast.LENGTH_LONG).show()
                }
                is ResultStatus.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                    binding.recyclerView.visibility = View.GONE
                }
            }
        })
    }

    private val listener = ViewListener { position ->
        val binding = DataBindingUtil.inflate<RowSliderBinding>(
            LayoutInflater.from(this@MainActivity), R.layout.row_slider, null, false
        )

        for (i in indexItems.indices) {
            binding.slider = indexItems.get(position)
        }

        binding.root
    }

    private fun renderSponsorList(lSponsors: MutableList<Sponsors>) {
        adapterSponsor.addData(lSponsors)
        adapterSponsor.notifyDataSetChanged()
    }

    private fun renderVendorList(lVendors: MutableList<Vendors>) {
        adapterVendor.addData(lVendors)
        adapterVendor.notifyDataSetChanged()
    }

    private fun renderList(lDiscount: MutableList<RecommendStatus>) {
        adapter.addData(lDiscount)
        adapter.notifyDataSetChanged()
    }

    override fun onClickProduct(id: Int) {
        val mIntent = Intent(this, DetailsActivity::class.java)
        mIntent.putExtra("productId", id)
        startActivity(mIntent)
    }

    override fun onDestroy() {
        super.onDestroy()
        finish()
    }
}