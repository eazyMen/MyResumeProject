package ru.summary.mysummaryproject.data.users

import io.reactivex.Single
import ru.summary.mysummaryproject.data.global.network.GlobalApi
import ru.summary.mysummaryproject.domain.global.common.SchedulersProvider
import ru.summary.mysummaryproject.domain.models.UsersModel
import ru.summary.mysummaryproject.domain.repositories.UsersRepository
import javax.inject.Inject

class UsersRepositoryImpl @Inject constructor(
    private var api: GlobalApi,
    private var schedulers: SchedulersProvider
) : UsersRepository {

    override fun getUsers(): Single<ArrayList<UsersModel>> = api.getUsers().subscribeOn(schedulers.io())

}