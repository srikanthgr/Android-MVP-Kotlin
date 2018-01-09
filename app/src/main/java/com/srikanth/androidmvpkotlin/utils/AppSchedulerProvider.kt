package com.srikanth.androidmvpkotlin.utils

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class AppSchedulerProvider : SchedulerProvider {
    override fun uiScheduler(): Scheduler {
        return Schedulers.io()
    }

    override fun ioScheduler(): Scheduler = AndroidSchedulers.mainThread()

}