package com.scoproject.androidcleanarchitecture.domain.movielist

import com.scoproject.androidcleanarchitecture.data.model.response.MovieList
import com.scoproject.androidcleanarchitecture.data.repository.MovieRepository
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by ibnumuzzakkir on 02/06/18.
 * Mobile Engineer
 */

class MovieListInteractor @Inject constructor(private val movieRepository: MovieRepository) : MovieListUseCase {
    override fun getMovieList(): Observable<List<MovieList.Result>> {
        return movieRepository.fetchMovies().flatMap { item ->
            val size = item.results?.size ?: 0
            if (size > 0) {
                val entities = mutableListOf<MovieList.Result>()
                item.results?.forEach { it ->
                    entities.add(MovieList.Result(
                            voteCount = it?.voteCount,
                            id = it?.id,
                            video = it?.video,
                            voteAverage = it?.voteAverage,
                            title = it?.title,
                            popularity = it?.popularity,
                            posterPath = it?.posterPath,
                            originalLanguage = it?.originalLanguage,
                            originalTitle = it?.originalTitle,
                            genreIds = it?.genreIds,
                            backdropPath = it?.backdropPath,
                            adult = it?.adult,
                            overview = it?.overview,
                            releaseDate = it?.releaseDate
                    ))
                }
                Observable.just(entities)
            } else {
                Observable.just(mutableListOf())
            }
        }
    }

}