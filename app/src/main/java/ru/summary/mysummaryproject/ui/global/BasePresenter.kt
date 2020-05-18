package ru.summary.mysummaryproject.ui.global

import io.reactivex.disposables.CompositeDisposable
import moxy.MvpPresenter
import moxy.MvpView
import ru.terrakok.cicerone.Router

open class BasePresenter<V : MvpView?>(private val router: Router)  : MvpPresenter<V>(){
    protected val subscriptions = CompositeDisposable()

    override fun onDestroy() = subscriptions.dispose()

    open fun onBackPressed() = router.exit()
}