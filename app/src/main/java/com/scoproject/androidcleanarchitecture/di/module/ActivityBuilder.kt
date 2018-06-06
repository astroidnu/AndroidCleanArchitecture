package com.scoproject.androidcleanarchitecture.di.module

import android.app.Activity
import com.scoproject.androidcleanarchitecture.presentation.feature.moviedetail.MovieDetailActivity
import com.scoproject.androidcleanarchitecture.presentation.feature.moviedetail.MovieDetailComponent
import com.scoproject.androidcleanarchitecture.presentation.feature.movielist.MovieListActivity
import com.scoproject.androidcleanarchitecture.presentation.feature.movielist.MovieListComponent
import dagger.Binds
import dagger.Module
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap

/**
 * Created by ibnumuzzakkir on 03/06/18.
 * Mobile Engineer
 */
@Module
abstract class ActivityBuilder {
    @Binds
    @IntoMap
    @ActivityKey(MovieListActivity::class)
    internal abstract fun bindMovieList(builder: MovieListComponent.Builder): AndroidInjector.Factory<out Activity>

    @Binds
    @IntoMap
    @ActivityKey(MovieDetailActivity::class)
    internal abstract fun bindMovieDetail(builder: MovieDetailComponent.Builder): AndroidInjector.Factory<out Activity>
}