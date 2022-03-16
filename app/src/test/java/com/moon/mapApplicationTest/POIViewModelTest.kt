package com.moon.mapApplicationTest

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth
import com.moon.mapApplicationTest.data.model.POI
import com.moon.mapApplicationTest.data.repository.AppRepository
import com.moon.mapApplicationTest.ui.poiList.IPOIListNavigator
import com.moon.mapApplicationTest.ui.poiList.POIViewModel
import com.moon.mapApplicationTest.utils.AppEnum
import com.moon.mapApplicationTest.utils.Resource
import com.nhaarman.mockitokotlin2.isNull
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mockito

@ExperimentalCoroutinesApi
@RunWith(JUnit4::class)
class POIViewModelTest {

    private lateinit var poiViewModel: POIViewModel
    private lateinit var repository: AppRepository
    private val testDispatcher = TestCoroutineDispatcher()

    private lateinit var mNavigator: IPOIListNavigator

    @get:Rule
    val instantTaskExecutionRule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun initSetUp() {
        Dispatchers.setMain(testDispatcher)
        repository = Mockito.mock(AppRepository::class.java)
        poiViewModel = POIViewModel(repository)
        mNavigator = Mockito.mock(IPOIListNavigator::class.java)
        poiViewModel.setNavigator(mNavigator)
    }


    @Test
    fun checkLoadingState_OnRequestInit_isTrue() {
        poiViewModel.isLoading.set(true)
        Truth.assertThat(poiViewModel.isLoading.get()).isEqualTo(true)
    }


    @Test
    fun checkLoadingState_OnRequestComplete_isFalse() {
        poiViewModel.isLoading.set(false)
        Truth.assertThat(poiViewModel.isLoading.get()).isFalse()
    }

    @Test
    fun getPOIListResponse_isSuccess() {
        val pois: ArrayList<POI> = arrayListOf()
        Mockito.`when`(
            Resource(
                status = Resource.Status.SUCCESS,
                data = null,
                message = null
            ).let { response ->
                when (response.status.name) {
                    AppEnum.API_CALL_STATUS.SUCCESS.name -> {
                        response.data?.let {
                            pois.addAll(it)
                        }
                        poiViewModel.isLoading.set(false)
                    }
                    AppEnum.API_CALL_STATUS.ERROR.name -> {
                        poiViewModel.isLoading.set(false)
                    }
                    AppEnum.API_CALL_STATUS.LOADING.name -> {
                        poiViewModel.isLoading.set(true)
                    }
                    else -> {

                    }
                }

            }
        ).thenReturn(isNull())
        Truth.assertThat(!pois.isNullOrEmpty()).isEqualTo(false)
        Truth.assertThat(poiViewModel.isLoading.get()).isEqualTo(false)
    }


    @After
    fun tearDown() {
        Dispatchers.resetMain()
        testDispatcher.cleanupTestCoroutines()
    }

}