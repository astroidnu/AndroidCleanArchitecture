package com.scoproject.androidcleanarchitecture.data.repository

import com.scoproject.androidcleanarchitecture.data.model.response.MovieDetail
import com.scoproject.androidcleanarchitecture.data.model.response.MovieList
import io.reactivex.Single

/**
 * Created by ibnumuzzakkir on 02/06/18.
 * Mobile Engineer
 */

interface MovieRepository {
    fun fetchMovies(): Single<MovieList.Response>
    fun fetchDetailMovie(movieId :String) : Single<MovieDetail.Response>
}