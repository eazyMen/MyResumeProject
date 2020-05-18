package ru.summary.mysummaryproject.domain.main.home

import ru.summary.mysummaryproject.domain.global.common.SchedulersProvider
import ru.summary.mysummaryproject.domain.repositories.UsersRepository
import javax.inject.Inject

class UsersInteractor @Inject constructor(
    private val api: UsersRepository,
    private val schedulers: SchedulersProvider
) {
    fun getUsers() = api.getUsers().observeOn(schedulers.ui())
}