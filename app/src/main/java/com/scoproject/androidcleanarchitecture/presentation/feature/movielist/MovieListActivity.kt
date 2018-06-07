package com.scoproject.androidcleanarchitecture.presentation.feature.movielist

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.View
import com.scoproject.androidcleanarchitecture.R
import com.scoproject.androidcleanarchitecture.data.model.response.MovieList
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
    lateinit var mPresenter: MovieListPresenter

    override fun onActivityReady(savedInstanceState: Bundle?) {
        mPresenter.attachView(this)
        mPresenter.getMovieList()
    }

    override fun onAutoAndroidInjector() {
        AndroidInjection.inject(this)
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_movie_list
    }

    override fun onStop() {
        super.onStop()
        mPresenter.detachView()
    }

    override fun showLoading() {
        pbMovieList.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        pbMovieList.visibility = View.GONE
    }

    override fun showError() {
        cl_movie_list.showSnackBar(resources.getString(R.string.error_get_list_movie))
    }

    override fun setupAdapter(data: List<MovieList.Result>) {
        rv_movie_list?.setUp(data, R.layout.item_movie, {
            it.fullpathMovieList.loadUriImage(context, iv_image_cover)
        }, {
            val movieId = it.id.toString()
            ll_item_movie.setOnClickListener {
                mActivityNavigation.goToDetailMoviePage(movieId)
            }
        }, GridLayoutManager(this, 2))
    }


}