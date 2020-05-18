package ru.summary.mysummaryproject.di.components.calendar

import dagger.Subcomponent
import ru.summary.mysummaryproject.di.FragmentScope
import ru.summary.mysummaryproject.ui.tabfragments.calendar.CalendarTabFragment

@Subcomponent(modules = [CalendarModule::class])

@FragmentScope
interface CalendarComponent {

    fun inject(fragment: CalendarTabFragment)

    @Subcomponent.Builder
    interface Builder {
        fun build(): CalendarComponent
    }
}