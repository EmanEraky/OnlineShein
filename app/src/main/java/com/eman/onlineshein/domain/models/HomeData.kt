package com.eman.onlineshein.domain.models

data class HomeData(
    val success: Boolean = false,
    val message: String = "",
    val data: DataComponents = DataComponents()
)