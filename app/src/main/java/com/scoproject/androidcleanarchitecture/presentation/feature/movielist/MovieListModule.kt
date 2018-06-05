package com.scoproject.androidcleanarchitecture.presentation.feature.movielist

import com.scoproject.androidcleanarchitecture.data.network.RestService
import com.scoproject.androidcleanarchitecture.data.repository.MovieDataStore
import com.scoproject.androidcleanarchitecture.data.repository.MovieRepository
import com.scoproject.androidcleanarchitecture.di.scope.ActivityScope
import com.scoproject.androidcleanarchitecture.domain.movielist.MovieListInteractor
import com.scoproject.androidcleanarchitecture.domain.movielist.MovieListUseCase
import dagger.Module
import dagger.Provides

/**
 * Created by ibnumuzzakkir on 02/06/18.
 * Mobile Engineer
 */

@Module
class MovieListModule {
    @Provides
    @ActivityScope
    fun provideMovieListActivity(movieListActivity: MovieListActivity) :  MovieListContract.View = movieListActivity

    @Provides
    @ActivityScope
    fun repository(restService: RestService): MovieRepository = MovieDataStore(restService)

    @Provides
    @ActivityScope
    fun usecase(repository: MovieRepository): MovieListUseCase = MovieListInteractor(repository)

    @Provides
    @ActivityScope
    fun presenter(movieListUseCase: MovieListUseCase): MovieListPresenter = MovieListPresenter(movieListUseCase)


}