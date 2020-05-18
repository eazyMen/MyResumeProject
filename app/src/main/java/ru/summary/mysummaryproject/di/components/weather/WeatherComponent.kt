package ru.summary.mysummaryproject.di.components.weather

import dagger.Subcomponent
import ru.summary.mysummaryproject.di.FragmentScope
import ru.summary.mysummaryproject.ui.tabfragments.weather.WeatherTabFragment

@Subcomponent(modules = [WeatherModule::class])

@FragmentScope
interface WeatherComponent {

    fun inject(fragment: WeatherTabFragment)

    @Subcomponent.Builder
    interface Builder {
        fun build(): WeatherComponent
    }
}