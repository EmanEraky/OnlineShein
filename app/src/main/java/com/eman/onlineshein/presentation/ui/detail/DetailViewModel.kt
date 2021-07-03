package com.eman.onlineshein.presentation.ui.detail

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eman.onlineshein.domain.models.DetailsProduct
import com.eman.onlineshein.domain.usecases.getDetailsUseCase
import com.eman.onlineshein.utils.NetworkHelper
import com.eman.onlineshein.utils.ResultStatus
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class DetailViewModel @ViewModelInject constructor
    (private val detailsUseCase: getDetailsUseCase, private val networkHelper: NetworkHelper) : ViewModel() {
    private val _detailsProduct = MutableLiveData<ResultStatus<DetailsProduct>>()

    val detailsProduct: MutableLiveData<ResultStatus<DetailsProduct>>
        get() = _detailsProduct


    fun getDetailResponse(id :Int) {
        viewModelScope.launch {
            _detailsProduct.postValue(ResultStatus.Loading)
            if (networkHelper.isNetworkConnected()) {
                detailsUseCase.getDetailProduct(id).collect {
                    _detailsProduct.postValue(it)
                }
            } else _detailsProduct.postValue(ResultStatus.Error("No internet connection"))
        }
    }


}