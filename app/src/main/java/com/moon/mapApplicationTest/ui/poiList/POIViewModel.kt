package com.moon.mapApplicationTest.ui.poiList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.moon.mapApplicationTest.data.model.POI
import com.moon.mapApplicationTest.data.model.POINode
import com.moon.mapApplicationTest.data.repository.AppRepository
import com.moon.mapApplicationTest.ui.base.BaseViewModel
import com.moon.mapApplicationTest.utils.AppEnum
import com.moon.mapApplicationTest.utils.Resource
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


    var poiList: ArrayList<POI> = arrayListOf()

    fun fetchPOIResponse() = viewModelScope.launch {
        repository.getPOI().collect { values ->
            _response.value = values
        }
    }

    fun getPOIResponse(response: Resource<POINode>) {
        when (response.status.name) {
            AppEnum.API_CALL_STATUS.SUCCESS.name -> {
                response.data?.let {
                    poiList.addAll(it)
                }
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