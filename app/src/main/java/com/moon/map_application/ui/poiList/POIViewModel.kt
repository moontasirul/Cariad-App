package com.moon.map_application.ui.poiList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.moon.map_application.data.model.POI
import com.moon.map_application.data.model.POINode
import com.moon.map_application.data.repository.AppRepository
import com.moon.map_application.ui.base.BaseViewModel
import com.moon.map_application.utils.AppEnum
import com.moon.map_application.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class POIViewModel @Inject constructor(
    private val repository: AppRepository
) : BaseViewModel<IPOIListNavigator>() {

    private val _response: MutableLiveData<Resource<POINode>> = MutableLiveData()
    val response: LiveData<Resource<POINode>> = _response


    var carList: ArrayList<POI> = arrayListOf()

    fun fetchCarResponse() = viewModelScope.launch {
        repository.getPOI().collect { values ->
            _response.value = values
        }
    }

    fun getCarResponse(response: Resource<POINode>) {
        when (response.status.name) {
            AppEnum.API_CALL_STATUS.SUCCESS.name -> {
                response.data?.let {
                    carList.addAll(it)
                }
                isLoading.set(false)
                navigator.addPOIMarker()
            }
            AppEnum.API_CALL_STATUS.ERROR.name -> {
                isLoading.set(false)
                response.message?.let { navigator.showFailedDialog(message = it) }
            }
            AppEnum.API_CALL_STATUS.LOADING.name -> {
                isLoading.set(true)
                print(response.message)
            }
        }
    }
}