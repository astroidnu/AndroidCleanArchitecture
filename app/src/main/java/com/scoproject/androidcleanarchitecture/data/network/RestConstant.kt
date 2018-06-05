package com.scoproject.androidcleanarchitecture.data.network

import com.scoproject.androidcleanarchitecture.BuildConfig

/**
 * Created by ibnumuzzakkir on 02/06/18.
 * Mobile Engineer
 */
object RestConstant {
    const val api_key = "api_key=${BuildConfig.API_KEY}"

    /**
     * List of end point Rest API
     * */

    const val moviePopular = "${BuildConfig.BASE_URL}movie/popular?$api_key"
    const val movieDetail = "${BuildConfig.BASE_URL}movie/{movie_id}?$api_key"

    /**
     * Image Settings
     * */

    const val baseImageUrl = "http://image.tmdb.org/t/p/"
    object imageSettings {
        val w185 = "w185"
        val w1280 = "w1280"
        val w342 = "w342"
        val original = "original"
    }
}

