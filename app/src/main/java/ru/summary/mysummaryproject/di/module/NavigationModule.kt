package ru.summary.mysummaryproject.di.module

import dagger.Module
import dagger.Provides
import ru.summary.mysummaryproject.di.FragmentScope
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import javax.inject.Named
import javax.inject.Singleton

@Module
class NavigationModule {


    private val provideNavigationHome = ProvideCicerone()

    @Provides
    @Singleton
    @Named("Home")
    fun provideRouterHome(): Router = provideNavigationHome.router

    @Provides
    @Singleton
    @Named("Home")
    fun provideViewHolderHome(): NavigatorHolder = provideNavigationHome.navigatorHolder

    private val provideNavigationCalendar = ProvideCicerone()

    @Provides
    @Singleton
    @Named("Calendar")
    fun provideRouterCalendar(): Router = provideNavigationCalendar.router

    @Provides
    @Singleton
    @Named("Calendar")
    fun provideViewHolderCalendar(): NavigatorHolder = provideNavigationCalendar.navigatorHolder

    private val provideNavigationWeather = ProvideCicerone()

    @Provides
    @Singleton
    @Named("Weather")
    fun provideRouterWeather(): Router = provideNavigationWeather.router

    @Provides
    @Singleton
    @Named("Weather")
    fun provideViewHolderWeather(): NavigatorHolder = provideNavigationWeather.navigatorHolder


    class ProvideCicerone {
        private val ciceroneHome: Cicerone<Router> = Cicerone.create()
        val router: Router = ciceroneHome.router
        val navigatorHolder: NavigatorHolder = ciceroneHome.navigatorHolder
    }
}