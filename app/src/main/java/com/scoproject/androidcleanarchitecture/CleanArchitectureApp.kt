package com.scoproject.androidcleanarchitecture

import android.app.Activity
import android.app.Application
import android.content.Context
import android.support.multidex.MultiDex
import com.scoproject.androidcleanarchitecture.di.component.AppComponent
import com.scoproject.androidcleanarchitecture.di.component.DaggerAppComponent
import com.scoproject.androidcleanarchitecture.di.module.NetworkModule
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

/**
 * Created by ibnumuzzakkir on 01/06/18.
 * Mobile Engineer
 */
class CleanArchitectureApp : Application(), HasActivityInjector {

    companion object {
        @JvmStatic
        lateinit var instance: CleanArchitectureApp
        @JvmStatic
        lateinit var appComponent: AppComponent
    }


    @Inject
    lateinit var mActivityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>



    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        //Initialize Multidex for prevent limit over 80k method
        MultiDex.install(this)
    }


    override fun onCreate() {
        super.onCreate()
        //Set Instance
        instance = this
        //Create App Component
        appComponent = createComponent()
        appComponent.inject(this)
    }



    override fun activityInjector(): AndroidInjector<Activity> {
        return mActivityDispatchingAndroidInjector
    }

    /**
     * Initialize Dependency Injection With Dagger
     * Level DI Application
     * */


    fun createComponent(): AppComponent {
        return DaggerAppComponent.builder()
                .application(this)
                .networkModule(NetworkModule(this))
                .build()
    }



}