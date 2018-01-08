package com.srikanth.androidmvpkotlin.utils

import io.reactivex.Scheduler

interface SchedulerProvider {
    fun usScheduler(): Scheduler
    fun ioScheduler(): Scheduler
}
