package com.scoproject.androidcleanarchitecture.domain.moviedetail

import com.scoproject.androidcleanarchitecture.data.model.entity.MovieDetail
import com.scoproject.androidcleanarchitecture.data.repository.MovieRepository
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by ibnumuzzakkir on 02/06/18.
 * Mobile Engineer
 */

class MovieDetailInteractor @Inject constructor(private val movieRepository: MovieRepository) : MovieDetailUseCase {
    override fun getMovieDetail(movieId: String): Single<MovieDetail> {
        return movieRepository.fetchDetailMovie(movieId).flatMap { item ->
            val entities = MovieDetail()
            entities.apply {
                movieTitle = item.originalTitle
                movieBackDropPath = item.backdropPath
                movieDescription = item.overview
            }
             Single.just(entities)
        }
    }

}