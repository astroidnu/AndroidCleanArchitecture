package com.scoproject.androidcleanarchitecture.presentation.feature.movielist

import com.scoproject.androidcleanarchitecture.di.scope.ActivityScope
import dagger.Subcomponent
import dagger.android.AndroidInjector

/**
 * Created by ibnumuzzakkir on 03/06/18.
 * Mobile Engineer
 */
@ActivityScope
@Subcomponent(modules = [(MovieListModule::class)])
interface MovieListComponent : AndroidInjector<MovieListActivity> {
    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<MovieListActivity>()
}