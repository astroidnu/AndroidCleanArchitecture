package com.scoproject.androidcleanarchitecture.domain.movielist

import com.scoproject.androidcleanarchitecture.data.model.response.MovieList
import io.reactivex.Observable

/**
 * Created by ibnumuzzakkir on 02/06/18.
 * Mobile Engineer
 */

interface MovieListUseCase {
    fun getMovieList() : Observable<List<MovieList.Result>>
}