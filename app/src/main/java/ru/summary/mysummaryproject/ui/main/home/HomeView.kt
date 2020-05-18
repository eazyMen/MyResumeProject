package ru.summary.mysummaryproject.ui.main.home

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType
import ru.summary.mysummaryproject.domain.models.UsersModel

@StateStrategyType(AddToEndSingleStrategy::class)
interface HomeView : MvpView {

    fun showUsers(user: ArrayList<UsersModel>)
    fun showError(message: String)

}