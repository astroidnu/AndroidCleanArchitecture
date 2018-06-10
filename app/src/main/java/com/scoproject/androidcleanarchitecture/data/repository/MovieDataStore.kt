package com.scoproject.androidcleanarchitecture.data.repository

import com.scoproject.androidcleanarchitecture.data.model.response.MovieDetail
import com.scoproject.androidcleanarchitecture.data.model.response.MovieList
import com.scoproject.androidcleanarchitecture.data.network.RestService
import com.scoproject.androidcleanarchitecture.external.scheduler.SchedulerProvider
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by ibnumuzzakkir on 03/06/18.
 * Mobile Engineer
 */

class MovieDataStore @Inject constructor(private val service: RestService, val scheduler : SchedulerProvider) : MovieRepository {

    override fun fetchMovies(): Observable<MovieList.Response> {
        return service.getPopularMovie()
                .subscribeOn(scheduler.io())
                .observeOn(scheduler.mainThread())
    }

    override fun fetchDetailMovie(movieId :String): Observable<MovieDetail.Response> {
        return service.getMovieDetail(movieId)
                .subscribeOn(scheduler.io())
                .observeOn(scheduler.mainThread())
    }
}