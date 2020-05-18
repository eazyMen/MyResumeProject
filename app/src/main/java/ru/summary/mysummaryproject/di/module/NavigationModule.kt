package ru.summary.mysummaryproject.di.module

import dagger.Module
import dagger.Provides
import ru.summary.mysummaryproject.di.FragmentScope
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Router
import javax.inject.Named
import javax.inject.Singleton

@Module
class NavigationModule {

    private val ciceroneHome: Cicerone<Router> = Cicerone.create()

    @Provides
    @Singleton
    @Named("Home")
    fun provideRouterHome() = ciceroneHome.router

    @Provides
    @Singleton
    @Named("Home")
    fun provideViewHolderHome() = ciceroneHome.navigatorHolder

    private val ciceroneCalendar: Cicerone<Router> = Cicerone.create()

    @Provides
    @Singleton
    @Named("Calendar")
    fun provideRouterCalendar() = ciceroneCalendar.router

    @Provides
    @Singleton
    @Named("Calendar")
    fun provideViewHolderCalendar() = ciceroneCalendar.navigatorHolder

    private val ciceroneWeather: Cicerone<Router> = Cicerone.create()

    @Provides
    @Singleton
    @Named("Weather")
    fun provideRouterWeather() = ciceroneWeather.router

    @Provides
    @Singleton
    @Named("Weather")
    fun provideViewHolderWeather() = ciceroneWeather.navigatorHolder

}