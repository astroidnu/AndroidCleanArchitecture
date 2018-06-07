package com.scoproject.androidcleanarchitecture.presentation.feature.moviedetail

import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.scoproject.androidcleanarchitecture.data.model.entity.MovieDetail
import com.scoproject.androidcleanarchitecture.domain.moviedetail.MovieDetailUseCase
import com.scoproject.weatherapp.util.TestSchedulerProvider
import io.reactivex.Observable
import io.reactivex.schedulers.TestScheduler
import org.junit.After
import org.junit.Before
import org.junit.Test

/**
 * Created by ibnumuzzakkir on 06/06/18.
 * Mobile Engineer
 */

class MovieDetailPresenterTest {
    private var useCase = mock<MovieDetailUseCase>()
    private val mView: MovieDetailContract.View = mock()

    private lateinit var mPresenter : MovieDetailPresenter
    private lateinit var mTestScheduler: TestScheduler

    @Before
    fun setup(){
        useCase = mock()
        mTestScheduler = TestScheduler()
        val testSchedulerProvider = TestSchedulerProvider(mTestScheduler)
        mPresenter = MovieDetailPresenter(useCase, testSchedulerProvider)
        mPresenter.attachView(mView)
    }

    @Test
    fun verifyGetMovieDetailReturnSuccessResponse(){
        val response : MovieDetail.MovieVO = mock()

        doReturn(Observable.just(response))
                .`when`(useCase)
                .getMovieDetail("132245")

        mPresenter.getMovieDetail("132245")

        verify(mView).showLoading()
        verify(mView).setContent(response.movieTitle,response.movieDescription,response.movieBackDropPath)
        verify(mView).hideLoading()
    }

    @Test
    fun verifyGetMovieDetailReturnErrorResponse(){
        val errResponse : Throwable = mock()
        doReturn(Observable.just(errResponse))
                .`when`(useCase)
                .getMovieDetail("132245")

        mPresenter.getMovieDetail("132245")
        verify(mView).showLoading()
        verify(mView).hideLoading()
        verify(mView).showError()
    }

    @After
    fun tearDown() {
        mPresenter.detachView()
    }
}