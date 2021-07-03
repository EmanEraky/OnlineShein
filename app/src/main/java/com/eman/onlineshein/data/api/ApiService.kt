package com.eman.onlineshein.data.api

import com.eman.onlineshein.domain.models.DetailsProduct
import com.eman.onlineshein.domain.models.HomeData
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {

    @GET("home-page")
    suspend fun getHomePage(): HomeData

    @POST("product-detalis?")
    suspend fun getProductDetails(@Query ("product_id") Id :Int): DetailsProduct

}