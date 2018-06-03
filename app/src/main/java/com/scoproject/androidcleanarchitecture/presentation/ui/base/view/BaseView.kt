package com.scoproject.androidcleanarchitecture.presentation.ui.base.view

import com.scoproject.androidcleanarchitecture.presentation.ui.base.presenter.BasePresenter

/**
 * Created by ibnumuzzakkir on 08/05/18.
 * Android Engineer
 * SCO Project
 */

interface BaseView{
    fun setPresenter(presenter: BasePresenter<*>)
}