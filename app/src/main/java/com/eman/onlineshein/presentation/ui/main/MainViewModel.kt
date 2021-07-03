package com.eman.onlineshein.presentation.ui.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eman.onlineshein.domain.models.HomeData
import com.eman.onlineshein.domain.usecases.getMainHomeUseCase
import com.eman.onlineshein.utils.NetworkHelper
import com.eman.onlineshein.utils.ResultStatus
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainViewModel @ViewModelInject constructor
    (private val mainUseCase: getMainHomeUseCase, private val networkHelper: NetworkHelper) :
    ViewModel() {
    private val _homeData = MutableLiveData<ResultStatus<HomeData>>()

    val homeData: MutableLiveData<ResultStatus<HomeData>>
        get() = _homeData

    init {
        getHomeResponse()
    }

    fun getHomeResponse() {
        viewModelScope.launch {
            _homeData.postValue(ResultStatus.Loading)
            if (networkHelper.isNetworkConnected()) {
                mainUseCase.getHomePage().collect {
                    _homeData.postValue(it)
                }
            } else _homeData.postValue(ResultStatus.Error("No internet connection"))
        }
    }


}