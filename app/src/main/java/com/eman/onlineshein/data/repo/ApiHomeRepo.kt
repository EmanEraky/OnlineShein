package com.eman.onlineshein.data.repo

import com.eman.onlineshein.data.api.ApiService
import com.eman.onlineshein.domain.models.HomeData
import com.eman.onlineshein.utils.ResultStatus
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ApiHomeRepo @Inject constructor(private val apiService: ApiService) : ApiHomeHelper {

    override suspend fun getHomePage(): Flow<ResultStatus<HomeData>> {
        return flow {
            emit(ResultStatus.Loading)
            val resource = try {
                val product = apiService.getHomePage()
                ResultStatus.Success(product)
            } catch (e: Throwable) {
                ResultStatus.Error(e.toString())
            }
            emit(resource)
        }
    }
}