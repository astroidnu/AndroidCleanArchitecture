package com.scoproject.androidcleanarchitecture.presentation.ui

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.scoproject.androidcleanarchitecture.presentation.ui.base.presenter.BasePresenter
import com.scoproject.androidcleanarchitecture.presentation.ui.base.view.BaseView
import org.junit.After
import org.junit.Before
import org.junit.Test

/**
 * Created by ibnumuzzakkir on 06/06/18.
 * Mobile Engineer
 */

class BasePresenterTest {
    private lateinit var basePresenter: BasePresenter<BaseView>
    private val view: BaseView = mock()

    @Before
    fun setUp() {
        basePresenter = BasePresenter()
    }

    @Test
    fun attachView() {
        basePresenter.attachView(view)
        verify(view).setPresenter(basePresenter)
    }

    @After
    fun tearDown(){
        basePresenter.detachView()
    }
}