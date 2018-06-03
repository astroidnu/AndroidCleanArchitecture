package com.scoproject.androidcleanarchitecture.presentation.feature.movielist

import com.scoproject.androidcleanarchitecture.domain.movielist.MovieListUseCase
import com.scoproject.androidcleanarchitecture.presentation.ui.base.presenter.BasePresenter
import javax.inject.Inject

/**
 * Created by ibnumuzzakkir on 02/06/18.
 * Mobile Engineer
 */

class MovieListPresenter @Inject constructor(val movieListUseCase: MovieListUseCase): BasePresenter<MovieListContract.View>(), MovieListContract.UserActionListener {

}