package com.scoproject.androidcleanarchitecture.presentation.ui.base.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.scoproject.androidcleanarchitecture.presentation.ui.base.view.BaseView
import com.scoproject.androidcleanarchitecture.presentation.ui.base.presenter.BasePresenter

/**
 * Created by ibnumuzzakkir on 08/05/18.
 * Android Engineer
 * SCO Project
 */

abstract class BaseActivity  : AppCompatActivity(), BaseView {
    private var presenter: BasePresenter<*>? = null

    /**
     * This function replace onCreate as main function run in activity
     * Auto Dependency Injection
     * @param Bundle
     * */

    abstract fun onActivityReady(savedInstanceState: Bundle?)

    abstract fun onAutoAndroidInjector()

    /**
     * Getting Layout ID from activity
     * */

    abstract fun getLayoutId(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        onAutoAndroidInjector()
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        onActivityReady(savedInstanceState)
    }

    override fun setPresenter(presenter: BasePresenter<*>) {
        this.presenter = presenter
    }


}