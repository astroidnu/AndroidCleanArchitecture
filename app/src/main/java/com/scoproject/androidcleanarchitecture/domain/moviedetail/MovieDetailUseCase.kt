package com.scoproject.androidcleanarchitecture.domain.moviedetail

import com.scoproject.androidcleanarchitecture.data.model.entity.MovieDetail
import io.reactivex.Observable

/**
 * Created by ibnumuzzakkir on 02/06/18.
 * Mobile Engineer
 */

interface MovieDetailUseCase {
    fun getMovieDetail(movieId: String): Observable<MovieDetail.MovieVO>
}