package com.moon.mapApplicationTest.ui.poiList

import com.moon.mapApplicationTest.ui.base.IBaseNavigator

interface IPOIListNavigator : IBaseNavigator {
    fun addPOIMarker()
    fun showFailedDialog(message: String)
}