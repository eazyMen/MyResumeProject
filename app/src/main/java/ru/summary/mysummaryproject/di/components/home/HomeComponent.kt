package ru.summary.mysummaryproject.di.components.home

import dagger.Subcomponent
import ru.summary.mysummaryproject.di.FragmentScope
import ru.summary.mysummaryproject.ui.main.home.HomeFragment
import ru.summary.mysummaryproject.ui.tabfragments.home.HomeTabFragment

@Subcomponent(modules = [HomeModule::class])
@FragmentScope
interface HomeComponent {

    fun inject(fragment: HomeTabFragment)
    fun inject(fragment: HomeFragment)

    @Subcomponent.Builder
    interface Builder {
        fun build(): HomeComponent
    }
}