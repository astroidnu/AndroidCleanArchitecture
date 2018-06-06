package com.scoproject.androidcleanarchitecture.data.repository

import com.scoproject.androidcleanarchitecture.data.model.response.MovieDetail
import com.scoproject.androidcleanarchitecture.data.model.response.MovieList
import com.scoproject.androidcleanarchitecture.data.network.RestService
import com.scoproject.androidcleanarchitecture.external.singleIo
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by ibnumuzzakkir on 03/06/18.
 * Mobile Engineer
 */

class MovieDataStore @Inject constructor(private val service: RestService) : MovieRepository {

    override fun fetchMovies(): Single<MovieList.Response> {
        return service.getPopularMovie().compose(singleIo())
    }

    override fun fetchDetailMovie(movieId :String): Single<MovieDetail.Response> {
        return service.getMovieDetail(movieId).compose(singleIo())
    }
}