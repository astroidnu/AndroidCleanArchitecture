package com.scoproject.androidcleanarchitecture.presentation.feature.movielist

import com.scoproject.androidcleanarchitecture.data.network.RestService
import com.scoproject.androidcleanarchitecture.data.repository.MovieDataStore
import com.scoproject.androidcleanarchitecture.data.repository.MovieRepository
import com.scoproject.androidcleanarchitecture.di.scope.ActivityScope
import com.scoproject.androidcleanarchitecture.domain.movielist.MovieListInteractor
import com.scoproject.androidcleanarchitecture.domain.movielist.MovieListUseCase
import com.scoproject.androidcleanarchitecture.presentation.ui.base.navigationcontroller.ActivityNavigation
import com.scoproject.weatherapp.utils.AppSchedulerProvider
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
    fun repository(restService: RestService, schedulerProvider: AppSchedulerProvider): MovieRepository = MovieDataStore(restService,schedulerProvider)

    @Provides
    @ActivityScope
    fun usecase(repository: MovieRepository): MovieListUseCase = MovieListInteractor(repository)

    @Provides
    @ActivityScope
    fun presenter(movieListUseCase: MovieListUseCase, schedulerProvider: AppSchedulerProvider): MovieListPresenter
            = MovieListPresenter(movieListUseCase, schedulerProvider)

    @Provides
    @ActivityScope
    fun navigation(movieListActivity: MovieListActivity) = ActivityNavigation(movieListActivity)
}