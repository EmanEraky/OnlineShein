package com.eman.onlineshein.domain.models

data class DataComponents(
    val Sliders: MutableList<Sliders> = mutableListOf(),
    val Sponsors: MutableList<Sponsors> = mutableListOf(),
    val vendor: MutableList<Vendors> = mutableListOf(),
    val recommend_paid_status: MutableList<RecommendStatus> = mutableListOf()
)