package com.eman.onlineshein.data.repo

import com.eman.onlineshein.data.api.ApiService
import com.eman.onlineshein.domain.models.DetailsProduct
import com.eman.onlineshein.utils.ResultStatus
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ApiDetailRepo @Inject constructor(private val apiService: ApiService) : ApiDetailHelper {

    override suspend fun getDetailProduct(id : Int): Flow<ResultStatus<DetailsProduct>> {
        return flow {
            emit(ResultStatus.Loading)
            val resource = try {
                val product = apiService.getProductDetails(id)
                ResultStatus.Success(product)
            } catch (e: Throwable) {
                ResultStatus.Error(e.toString())
            }
            emit(resource)
        }
    }
}