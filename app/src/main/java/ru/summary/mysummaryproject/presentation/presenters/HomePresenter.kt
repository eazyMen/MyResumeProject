package ru.summary.mysummaryproject.presentation.presenters

import io.reactivex.rxkotlin.plusAssign
import io.reactivex.rxkotlin.subscribeBy
import moxy.InjectViewState
import ru.summary.mysummaryproject.domain.main.home.UsersInteractor
import ru.summary.mysummaryproject.ui.global.BasePresenter
import ru.summary.mysummaryproject.ui.main.home.HomeView
import ru.terrakok.cicerone.Router
import javax.inject.Inject
import javax.inject.Named

@InjectViewState
class HomePresenter @Inject constructor(
    @Named("Home")
    private val router: Router,
    private val interactor: UsersInteractor
) : BasePresenter<HomeView>(router) {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        subscriptions += interactor.getUsers()
            .subscribeBy(
                onSuccess = {
                    viewState.showUsers(it)
                },
                onError = {
                    viewState.showError(it.message ?: "")
                }
            )
    }
}