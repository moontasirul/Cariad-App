package com.moon.map_application.data.remote.dataSource

import com.moon.map_application.data.remote.apiService.IPOIService
import com.moon.map_application.data.remote.dataSource.baseDataSource.BaseDataSource
import com.moon.map_application.utils.Constants
import javax.inject.Inject

class POIRemoteDataSource  @Inject constructor(
    private val poiService: IPOIService
): BaseDataSource() {
    suspend fun getAllPOIData() = getResult { poiService.getAllPOI(52.526,13.415,5,Constants.ASSESS_TOKEN) }
}