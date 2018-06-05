package com.scoproject.androidcleanarchitecture.di.component

import android.app.Application
import com.scoproject.androidcleanarchitecture.CleanArchitectureApp
import com.scoproject.androidcleanarchitecture.di.module.ActivityBuilder
import com.scoproject.androidcleanarchitecture.di.module.AppModule
import com.scoproject.androidcleanarchitecture.di.module.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

/**
 * Created by ibnumuzzakkir on 01/06/18.
 * Mobile Engineer
 */

@Singleton
@Component(modules = [(AndroidInjectionModule::class),
    (AppModule::class),
    (ActivityBuilder::class),
    (NetworkModule::class)])
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun networkModule(networkModule: NetworkModule): Builder
        fun build(): AppComponent
    }

    fun inject(app: CleanArchitectureApp)
}