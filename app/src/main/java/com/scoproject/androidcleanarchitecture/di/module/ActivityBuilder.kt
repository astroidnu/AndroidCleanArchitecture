package com.scoproject.androidcleanarchitecture.di.module

import android.app.Activity
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
    internal abstract fun bindLoginActivity(builder: MovieListComponent.Builder): AndroidInjector.Factory<out Activity>
}