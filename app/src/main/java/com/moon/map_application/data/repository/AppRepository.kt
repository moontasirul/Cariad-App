package com.moon.map_application.data.repository

import com.moon.map_application.data.local.prefs.AppPreferences
import com.moon.map_application.data.model.POINode
import com.moon.map_application.data.remote.dataSource.POIRemoteDataSource
import com.moon.map_application.data.remote.dataSource.baseDataSource.BaseDataSource
import com.moon.map_application.utils.Resource
import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

@ActivityRetainedScoped
class AppRepository @Inject constructor(
    private var POIDataSource: POIRemoteDataSource,
    private var preferences: AppPreferences
) : BaseDataSource() {

    suspend fun getPOI(): Flow<Resource<POINode>> {
        return flow {
            emit(POIDataSource.getAllPOIData())
        }.flowOn(Dispatchers.IO)
    }
}