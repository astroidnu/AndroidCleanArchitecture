package com.scoproject.androidcleanarchitecture.presentation.ui.base.navigationcontroller

import android.support.v7.app.AppCompatActivity
import com.scoproject.androidcleanarchitecture.presentation.feature.moviedetail.MovieDetailActivity
import javax.inject.Inject

/**
 * Created by ibnumuzzakkir on 06/06/18.
 * Mobile Engineer
 */
class ActivityNavigation @Inject constructor(val activity : AppCompatActivity) : BaseActivityNavigation(){

    /**
     * Go to Detail Movie Page
     * */

    fun goToDetailMoviePage(movieId : String) {
        var intent = newIntent(activity, MovieDetailActivity::class.java)
        intent.apply {
            putExtra(MovieDetailActivity.TAG_MOVIE_ID, movieId)
        }
        activity.startActivity(intent)
    }

}