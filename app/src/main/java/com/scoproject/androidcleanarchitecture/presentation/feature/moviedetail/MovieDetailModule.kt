package com.scoproject.androidcleanarchitecture.presentation.feature.moviedetail

import com.scoproject.androidcleanarchitecture.data.network.RestService
import com.scoproject.androidcleanarchitecture.data.repository.MovieDataStore
import com.scoproject.androidcleanarchitecture.data.repository.MovieRepository
import com.scoproject.androidcleanarchitecture.di.scope.ActivityScope
import com.scoproject.androidcleanarchitecture.domain.moviedetail.MovieDetailInteractor
import com.scoproject.androidcleanarchitecture.domain.moviedetail.MovieDetailUseCase
import com.scoproject.androidcleanarchitecture.presentation.ui.base.navigationcontroller.ActivityNavigation
import dagger.Module
import dagger.Provides

/**
 * Created by ibnumuzzakkir on 02/06/18.
 * Mobile Engineer
 */
@Module
class MovieDetailModule {
    @Provides
    @ActivityScope
    fun provideActiviy(movieDetailActivity: MovieDetailActivity) :  MovieDetailContract.View = movieDetailActivity

    @Provides
    @ActivityScope
    fun repository(restService: RestService): MovieRepository = MovieDataStore(restService)

    @Provides
    @ActivityScope
    fun usecase(repository: MovieRepository): MovieDetailUseCase = MovieDetailInteractor(repository)

    @Provides
    @ActivityScope
    fun presenter(movieDetailUseCase: MovieDetailUseCase): MovieDetailPresenter = MovieDetailPresenter(movieDetailUseCase)

    @Provides
    @ActivityScope
    fun navigation(activity : MovieDetailActivity) = ActivityNavigation(activity)
}