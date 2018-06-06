package com.scoproject.androidcleanarchitecture.presentation.feature.moviedetail

import com.scoproject.androidcleanarchitecture.di.scope.ActivityScope
import dagger.Subcomponent
import dagger.android.AndroidInjector

/**
 * Created by ibnumuzzakkir on 06/06/18.
 * Mobile Engineer
 */
@ActivityScope
@Subcomponent(modules = [(MovieDetailModule::class)])
interface MovieDetailComponent : AndroidInjector<MovieDetailActivity> {
    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<MovieDetailActivity>()
}