package ru.summary.mysummaryproject.di.global

import dagger.Module
import dagger.Provides
import ru.summary.mysummaryproject.domain.global.common.SchedulersProvider
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideSchedulersProvider() = SchedulersProvider()
}