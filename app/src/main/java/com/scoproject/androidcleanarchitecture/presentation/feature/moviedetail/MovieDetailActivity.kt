package com.scoproject.androidcleanarchitecture.presentation.feature.moviedetail

import android.os.Bundle
import android.view.View
import com.scoproject.androidcleanarchitecture.R
import com.scoproject.androidcleanarchitecture.data.network.RestConstant
import com.scoproject.androidcleanarchitecture.external.loadUriImage
import com.scoproject.androidcleanarchitecture.external.showToast
import com.scoproject.androidcleanarchitecture.presentation.ui.base.activity.BaseActivity
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_movie_detail.*
import javax.inject.Inject

/**
 * Created by ibnumuzzakkir on 02/06/18.
 * Mobile Engineer
 */

class MovieDetailActivity : BaseActivity(), MovieDetailContract.View {
    companion object {
        val TAG_MOVIE_ID = "movie_id"
    }
    @Inject
    lateinit var mPresenter: MovieDetailPresenter

    override fun onActivityReady(savedInstanceState: Bundle?) {
        mPresenter.attachView(this)
        setupActionBar()

        val mBundle = intent.extras
        mBundle.let {
            val movieId = it.getString(TAG_MOVIE_ID)
            mPresenter.getMovieDetail(movieId = movieId)
        }
    }

    override fun onAutoAndroidInjector() {
        AndroidInjection.inject(this)
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_movie_detail
    }

    override fun onStop() {
        super.onStop()
        mPresenter.detachView()
    }

    override fun setupActionBar() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun showLoading() {
        pbMovieDetail.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        pbMovieDetail.visibility = View.GONE
    }

    override fun setContent(movieTitle: String?, movieDesc: String?, posterUrl: String?) {
        tvMovieDescription.text = movieDesc
        tvMovieTitle.text = movieTitle
        val fullpath = "${RestConstant.baseImageUrl}${RestConstant.imageSettings.w1280}/$posterUrl"
        fullpath.loadUriImage(this, ivMovieDetail)
    }

    override fun showMessage(msg: String) {
        showToast(msg)
    }
}