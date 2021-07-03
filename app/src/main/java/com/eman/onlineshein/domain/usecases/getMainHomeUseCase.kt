package com.eman.onlineshein.domain.usecases

import com.eman.onlineshein.data.repo.ApiHomeHelper
import javax.inject.Inject

class getMainHomeUseCase @Inject constructor(private val apiHomeHelper: ApiHomeHelper) {

    suspend fun getHomePage() =
        apiHomeHelper.getHomePage()


}