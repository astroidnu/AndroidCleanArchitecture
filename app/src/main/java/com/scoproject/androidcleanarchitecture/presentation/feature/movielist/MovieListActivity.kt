package com.scoproject.androidcleanarchitecture.presentation.feature.movielist

import android.os.Bundle
import com.scoproject.androidcleanarchitecture.R
import com.scoproject.androidcleanarchitecture.presentation.ui.base.activity.BaseActivity
import dagger.android.AndroidInjection

/**
 * Created by ibnumuzzakkir on 02/06/18.
 * Mobile Engineer
 */

class MovieListActivity : BaseActivity() {
    override fun onActivityReady(savedInstanceState: Bundle?) {

    }

    override fun onAutoAndroidInjector() {
        AndroidInjection.inject(this)
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_movie_list
    }

}