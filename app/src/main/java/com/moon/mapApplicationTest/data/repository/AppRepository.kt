package com.moon.mapApplicationTest.data.repository

import com.moon.mapApplicationTest.data.local.prefs.AppPreferences
import com.moon.mapApplicationTest.data.model.POINode
import com.moon.mapApplicationTest.data.remote.dataSource.POIRemoteDataSource
import com.moon.mapApplicationTest.data.remote.dataSource.baseDataSource.BaseDataSource
import com.moon.mapApplicationTest.utils.Resource
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