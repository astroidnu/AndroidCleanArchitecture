package com.scoproject.androidcleanarchitecture.presentation.ui

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.scoproject.androidcleanarchitecture.presentation.ui.base.presenter.BasePresenter
import com.scoproject.androidcleanarchitecture.presentation.ui.base.view.BaseView
import com.scoproject.weatherapp.util.TestSchedulerProvider
import io.reactivex.schedulers.TestScheduler
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
    private lateinit var mTestScheduler: TestScheduler

    @Before
    fun setUp() {
        mTestScheduler = TestScheduler()
        val testSchedulerProvider = TestSchedulerProvider(mTestScheduler)
        basePresenter = BasePresenter(testSchedulerProvider)
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