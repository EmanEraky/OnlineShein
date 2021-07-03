package com.eman.onlineshein.data.repo

import com.eman.onlineshein.domain.models.DetailsProduct
import com.eman.onlineshein.utils.ResultStatus
import kotlinx.coroutines.flow.Flow

interface ApiDetailHelper {
    suspend fun getDetailProduct(id :Int): Flow<ResultStatus<DetailsProduct>>

}