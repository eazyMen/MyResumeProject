package ru.summary.mysummaryproject.di.components.home

import dagger.Module
import dagger.Provides
import ru.summary.mysummaryproject.di.FragmentScope
import ru.summary.mysummaryproject.domain.global.common.SchedulersProvider
import ru.summary.mysummaryproject.domain.main.home.UsersInteractor
import ru.summary.mysummaryproject.domain.repositories.UsersRepository

@Module
class HomeModule {

    @Provides
    @FragmentScope
    fun provideInteractor(repository: UsersRepository, schedulers: SchedulersProvider) =
        UsersInteractor(repository, schedulers)

//    @Provides
//    @FragmentScope
//    fun providePresenter(@Named("Home") router: Router): HomePresenter = HomePresenter(router)
}