package com.eman.onlineshein.domain.models

data class Products (
    val id: Int = 1,
    val name: String = "",
    val description: String = "",
    val vendor: String = "",
    val image: String = "",
    val new_price: Int = 0,
    val old_price: Int = 0,
    val lat: String = "",
    val lng: String = "",
    val email: String = "",
    val mobile: String = "",
    val address: String = "",
    val rate :Int =0,
    val Gallary : MutableList<GalleryPhoto> = mutableListOf(),
    val review: MutableList<Review> = mutableListOf()

)