package com.scoproject.androidcleanarchitecture.presentation.feature.moviedetail

import com.scoproject.androidcleanarchitecture.presentation.ui.base.view.BaseView

/**
 * Created by ibnumuzzakkir on 02/06/18.
 * Mobile Engineer
 */

class MovieDetailContract {
    interface View : BaseView {
        fun showLoading()
        fun hideLoading()
        fun setupActionBar()
        fun showError()
        fun setContent(movieTitle: String?, movieDesc: String?, posterUrl: String?)
    }

    interface UserActionListener {
        fun getMovieDetail(movieId: String)
    }
}