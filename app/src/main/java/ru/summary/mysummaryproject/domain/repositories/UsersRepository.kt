package ru.summary.mysummaryproject.domain.repositories

import io.reactivex.Single
import ru.summary.mysummaryproject.domain.models.UsersModel

interface UsersRepository {
    fun getUsers(): Single<ArrayList<UsersModel>>
}