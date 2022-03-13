package com.moon.map_application.ui.poiDetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.moon.map_application.data.repository.AppRepository
import com.moon.map_application.ui.base.BaseViewModel
import com.moon.map_application.utils.AppEnum
import com.moon.map_application.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class POIDetailsViewModel @Inject constructor(
    private val repository: AppRepository
) : BaseViewModel<IPOIDetailsNavigator>() {


}