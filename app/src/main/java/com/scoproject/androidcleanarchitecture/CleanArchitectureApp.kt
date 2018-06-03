package com.scoproject.androidcleanarchitecture

import android.app.Activity
import android.app.Application
import android.content.Context
import android.support.multidex.MultiDex
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

/**
 * Created by ibnumuzzakkir on 01/06/18.
 * Mobile Engineer
 */
class CleanArchitectureApp : Application(), HasActivityInjector {

    @Inject
    lateinit var mActivityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        //Initialize Multidex for prevent limit over 80k method
        MultiDex.install(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> {
        return mActivityDispatchingAndroidInjector
    }


}