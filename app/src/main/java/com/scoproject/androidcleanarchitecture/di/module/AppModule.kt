package com.scoproject.androidcleanarchitecture.di.module

import android.app.Application
import android.content.Context
import com.scoproject.androidcleanarchitecture.presentation.feature.movielist.MovieListComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by ibnumuzzakkir on 01/06/18.
 * Mobile Engineer
 */
@Module(subcomponents = [(MovieListComponent::class)])
class AppModule {
    @Provides
    @Singleton
    internal fun provideContext(application: Application): Context  = application
}