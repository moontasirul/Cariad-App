package com.moon.map_application.ui.poiList

import com.moon.map_application.ui.base.IBaseNavigator

interface IPOIListNavigator : IBaseNavigator {
    fun addPOIMarker()
    fun showFailedDialog(message: String)
}