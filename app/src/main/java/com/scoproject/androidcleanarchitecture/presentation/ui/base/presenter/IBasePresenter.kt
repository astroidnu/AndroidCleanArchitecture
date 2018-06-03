package com.scoproject.androidcleanarchitecture.presentation.ui.base.presenter

import com.scoproject.androidcleanarchitecture.presentation.ui.base.view.BaseView

/**
 * Created by ibnumuzzakkir on 08/05/18.
 * Android Engineer
 * SCO Project
 */

interface IBasePresenter<in V : BaseView> {

    fun attachView(view: V)

    fun detachView()
}