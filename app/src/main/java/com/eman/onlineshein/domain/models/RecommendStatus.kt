package com.eman.onlineshein.domain.models

data class RecommendStatus (
    val id: Int = 1,
    val name: String = "",
    val image: String = "",
    val new_price: Int = 0,
    val old_price: Int = 0,
    val rate: Int = 0,
    val ProductUserNumber: Int = 0,
    val exp_date: String = ""
)

