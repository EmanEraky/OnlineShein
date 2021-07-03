package com.eman.onlineshein.domain.models


data class DetailsProduct(
    val success: Boolean = false,
    val message: String = "",
    val data: ProductData = ProductData()
)