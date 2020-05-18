package ru.summary.mysummaryproject.domain.global.common

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

open class SchedulersProvider {
    open fun ui(): Scheduler = AndroidSchedulers.mainThread()
    open fun io(): Scheduler = Schedulers.io()
}