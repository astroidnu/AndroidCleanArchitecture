package com.scoproject.androidcleanarchitecture.presentation.feature.moviedetail

import com.scoproject.androidcleanarchitecture.domain.moviedetail.MovieDetailUseCase
import com.scoproject.androidcleanarchitecture.external.scheduler.SchedulerProvider
import com.scoproject.androidcleanarchitecture.presentation.ui.base.presenter.BasePresenter
import javax.inject.Inject

/**
 * Created by ibnumuzzakkir on 02/06/18.
 * Mobile Engineer
 */

class MovieDetailPresenter  @Inject constructor(private val useCase: MovieDetailUseCase,  scheduler : SchedulerProvider):
        BasePresenter<MovieDetailContract.View>(scheduler), MovieDetailContract.UserActionListener  {


    override fun getMovieDetail(movieId: String) {
        view?.showLoading()
        addDisposable(useCase.getMovieDetail(movieId)
                .subscribe ({ data ->
                    view?.setContent(data.movieTitle,data.movieDescription,data.movieBackDropPath)
                    view?.hideLoading()
                },{
                    _ ->
                    view?.hideLoading()
                    view?.showError()
                }))

    }

}