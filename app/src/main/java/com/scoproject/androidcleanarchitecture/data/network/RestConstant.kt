package com.scoproject.androidcleanarchitecture.data.network

import com.scoproject.androidcleanarchitecture.BuildConfig

/**
 * Created by ibnumuzzakkir on 02/06/18.
 * Mobile Engineer
 */
object RestConstant {
    const val api_key = "api_key=${BuildConfig.API_KEY}"

    const val moviePopular = "${BuildConfig.BASE_URL}movie/popular?$api_key"
}