package ru.summary.mysummaryproject.data.global.network

import io.reactivex.Single
import retrofit2.http.GET
import ru.summary.mysummaryproject.domain.models.UsersModel

interface GlobalApi {
    @GET("users")
    fun getUsers(): Single<ArrayList<UsersModel>>
}