package com.scoproject.androidcleanarchitecture.data.network

import com.scoproject.androidcleanarchitecture.data.model.response.MovieList
import io.reactivex.Single
import retrofit2.http.GET

/**
 * Created by ibnumuzzakkir on 02/06/18.
 * Mobile Engineer
 */
interface RestService {
    @GET(RestConstant.moviePopular)
    fun getPopularMovie(): Single<MovieList.Response>
}