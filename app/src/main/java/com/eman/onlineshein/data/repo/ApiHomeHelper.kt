package com.eman.onlineshein.data.repo

import com.eman.onlineshein.domain.models.HomeData
import com.eman.onlineshein.utils.ResultStatus
import kotlinx.coroutines.flow.Flow

interface ApiHomeHelper {
    suspend fun getHomePage(): Flow<ResultStatus<HomeData>>




}