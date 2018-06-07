package com.scoproject.androidcleanarchitecture.presentation.feature.movielist

import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.scoproject.androidcleanarchitecture.data.model.response.MovieList
import com.scoproject.androidcleanarchitecture.domain.movielist.MovieListUseCase
import io.reactivex.Observable
import org.junit.After
import org.junit.Before
import org.junit.Test

/**
 * Created by ibnumuzzakkir on 06/06/18.
 * Mobile Engineer
 */

class MovieListPresenterTest {
    private var useCase = mock<MovieListUseCase>()
    private val mView: MovieListContract.View = mock()

    private lateinit var mPresenter : MovieListPresenter

    @Before
    fun setup(){
        useCase = mock()
        mPresenter = MovieListPresenter(useCase)
        mPresenter.attachView(mView)
    }

    @Test
    fun verifyGetMovieListReturnSuccessResponse(){
        val response : List<MovieList.Result> = mock()

        doReturn(Observable.just(response))
                .`when`(useCase)
                .getMovieList()

        mPresenter.getMovieList()

        verify(mView).showLoading()
        verify(mView).setupAdapter(response)
        verify(mView).hideLoading()
    }

    @Test
    fun verifyGetMovieListReturnErrorResponse(){
        doReturn(Observable.just(""))
                .`when`(useCase)
                .getMovieList()

        mPresenter.getMovieList()

        verify(mView).showLoading()
        verify(mView).hideLoading()
        verify(mView).showMessage("java.lang.String cannot be cast to java.util.List")
    }

    @After
    fun tearDown() {
        mPresenter.detachView()
    }
}