package com.moon.mapApplicationTest.ui.poiDetails

import androidx.lifecycle.MutableLiveData
import com.moon.mapApplicationTest.data.model.POI
import com.moon.mapApplicationTest.data.repository.AppRepository
import com.moon.mapApplicationTest.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class POIDetailsViewModel @Inject constructor(
    private val repository: AppRepository
) : BaseViewModel<IPOIDetailsNavigator>() {


    var poiTitle = MutableLiveData<String>()
    var chargingStationAddress = MutableLiveData<String>()
    var numberOfChargingPoints = MutableLiveData<String>()


    fun showPOIInfo(poi: POI?) {
        poi?.AddressInfo?.Title?.let {
            poiTitle.value= it
        }

        poi?.AddressInfo?.AddressLine1?.let {
            chargingStationAddress.value= it
        }

        poi?.NumberOfPoints?.let {
            numberOfChargingPoints.value= it.toString()
        }
    }
}