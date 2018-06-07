package com.scoproject.androidcleanarchitecture.data.network

import com.scoproject.androidcleanarchitecture.data.model.response.MovieDetail
import com.scoproject.androidcleanarchitecture.data.model.response.MovieList
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by ibnumuzzakkir on 02/06/18.
 * Mobile Engineer
 */
interface RestService {
    @GET(RestConstant.moviePopular)
    fun getPopularMovie(): Observable<MovieList.Response>

    @GET(RestConstant.movieDetail)
    fun getMovieDetail(@Path("movie_id") movieId :String): Observable<MovieDetail.Response>
}