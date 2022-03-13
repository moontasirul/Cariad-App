package com.moon.map_application.data.remote.apiService

import com.moon.map_application.data.model.POINode
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface IPOIService {//?{latitude}&{longitude}&{distance}&{key}
//https://api.openchargemap.io/v3/poi?latitude=52.526&longitude=13.415&distance=5&key=1e2cb9c6-a0e9-4a68-bc09-f3c97a6bd8e4
    @GET("poi?")
    suspend fun getAllPOI(@Query("latitude") latitude: Double,
                          @Query("longitude") longitude: Double,
                          @Query("distance") distance: Int,
                          @Query("key") key: String): Response<POINode>

}