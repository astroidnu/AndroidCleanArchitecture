package com.scoproject.androidcleanarchitecture.repository

import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.mock
import com.scoproject.androidcleanarchitecture.data.model.response.MovieDetail
import com.scoproject.androidcleanarchitecture.data.model.response.MovieList
import com.scoproject.androidcleanarchitecture.data.network.RestService
import com.scoproject.androidcleanarchitecture.data.repository.MovieDataStore
import com.scoproject.weatherapp.util.TestSchedulerProvider
import io.reactivex.Observable
import io.reactivex.schedulers.TestScheduler
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

/**
 * Created by ibnumuzzakkir on 07/06/18.
 * Mobile Engineer
 */

class MovieDataStoreTest {
    private var service = mock<RestService>()
    private lateinit var mDataStore: MovieDataStore
    private lateinit var mTestScheduler: TestScheduler

    @Before
    fun setup() {
        service = mock()
        mTestScheduler = TestScheduler()
        val testSchedulerProvider = TestSchedulerProvider(mTestScheduler)
        mDataStore = MovieDataStore(service, testSchedulerProvider)
    }

    @Test
    fun verifyGetMoviesDataStoreReturnResult(){
        val response  : MovieList.Response = mock()
        val observeObject = Observable.just(response)
        doReturn(observeObject)
                .`when`(service)
                .getPopularMovie()
        mDataStore.fetchMovies()

        mTestScheduler.triggerActions()

        assertEquals(observeObject, service.getPopularMovie())
    }



    @Test
    fun verifyGetDetailMovieDataStoreReturnResult(){
        val response  : MovieDetail.Response = mock()
        val observeObject = Observable.just(response)
        doReturn(observeObject)
                .`when`(service)
                .getMovieDetail("123131")
        mDataStore.fetchDetailMovie("123131")

        mTestScheduler.triggerActions()

        assertEquals(observeObject, service.getMovieDetail("123131"))
    }
}