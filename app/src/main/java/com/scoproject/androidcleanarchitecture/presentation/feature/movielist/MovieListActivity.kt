package com.scoproject.androidcleanarchitecture.presentation.feature.movielist

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import com.scoproject.androidcleanarchitecture.R
import com.scoproject.androidcleanarchitecture.data.model.response.MovieList
import com.scoproject.androidcleanarchitecture.data.network.RestConstant
import com.scoproject.androidcleanarchitecture.external.loadUriImage
import com.scoproject.androidcleanarchitecture.external.setUp
import com.scoproject.androidcleanarchitecture.external.showSnackBar
import com.scoproject.androidcleanarchitecture.presentation.ui.base.activity.BaseActivity
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_movie_list.*
import kotlinx.android.synthetic.main.item_movie.view.*
import javax.inject.Inject

/**
 * Created by ibnumuzzakkir on 02/06/18.
 * Mobile Engineer
 */

class MovieListActivity : BaseActivity(), MovieListContract.View {
    @Inject
    lateinit var mMovieListPresenter: MovieListPresenter

    override fun onActivityReady(savedInstanceState: Bundle?) {
        mMovieListPresenter.attachView(this)
        mMovieListPresenter.getMovieList()
    }

    override fun onAutoAndroidInjector() {
        AndroidInjection.inject(this)
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_movie_list
    }

    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    override fun showMessage(msg: String) {
        cl_movie_list.showSnackBar(msg)
    }

    override fun setupAdapter(data: List<MovieList.Result>) {
        rv_movie_list?.setUp(data, R.layout.item_movie, {
            val fullpath = "${RestConstant.baseImageUrl}${RestConstant.imageSettings.w342}/${it.posterPath}"
            fullpath.loadUriImage(context, iv_image_cover)
        },{
            val movieTitle = it.title
            iv_image_cover.setOnClickListener {
                movieTitle?.let {
                    showMessage(it)
                }

            }
        },GridLayoutManager(this, 2))
    }



}