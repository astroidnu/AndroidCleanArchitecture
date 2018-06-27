package com.scoproject.weatherapp.util

import com.scoproject.androidcleanarchitecture.external.scheduler.SchedulerProvider
import io.reactivex.Scheduler
import io.reactivex.schedulers.TestScheduler



class TestSchedulerProvider constructor(private val testScheduler: TestScheduler) : SchedulerProvider {

    override fun ui(): Scheduler = testScheduler
    override fun computation(): Scheduler = testScheduler
    override fun io(): Scheduler = testScheduler
    override fun mainThread(): Scheduler = testScheduler
}