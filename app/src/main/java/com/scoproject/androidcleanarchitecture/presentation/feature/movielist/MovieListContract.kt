package com.scoproject.androidcleanarchitecture.presentation.feature.movielist

import com.scoproject.androidcleanarchitecture.data.model.response.MovieList
import com.scoproject.androidcleanarchitecture.presentation.ui.base.view.BaseView

/**
 * Created by ibnumuzzakkir on 02/06/18.
 * Mobile Engineer
 */

class MovieListContract {
    interface View : BaseView {
        fun showLoading()
        fun hideLoading()
        fun showError()
        fun setupAdapter(data : List<MovieList.Result>)
    }

    interface UserActionListener {
        fun getMovieList()
    }
}