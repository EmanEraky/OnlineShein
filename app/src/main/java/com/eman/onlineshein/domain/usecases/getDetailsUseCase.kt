package com.eman.onlineshein.domain.usecases

import com.eman.onlineshein.data.repo.ApiDetailHelper
import javax.inject.Inject

class getDetailsUseCase @Inject constructor(private val apiDetailHelper: ApiDetailHelper) {

    suspend fun getDetailProduct(id :Int) =
        apiDetailHelper.getDetailProduct(id)


}