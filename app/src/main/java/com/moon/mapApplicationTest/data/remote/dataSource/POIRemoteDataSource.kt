package com.moon.mapApplicationTest.data.remote.dataSource

import com.moon.mapApplicationTest.data.remote.apiService.IPOIService
import com.moon.mapApplicationTest.data.remote.dataSource.baseDataSource.BaseDataSource
import com.moon.mapApplicationTest.utils.Constants
import javax.inject.Inject

class POIRemoteDataSource  @Inject constructor(
    private val poiService: IPOIService
): BaseDataSource() {
    suspend fun getAllPOIData() = getResult { poiService.getAllPOI(52.526,13.415,5,Constants.ASSESS_TOKEN) }
}