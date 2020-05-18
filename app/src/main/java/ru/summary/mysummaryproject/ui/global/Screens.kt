package ru.summary.mysummaryproject.ui.global

import ru.summary.mysummaryproject.ui.main.calendar.CalendarFragment
import ru.summary.mysummaryproject.ui.main.home.HomeFragment
import ru.summary.mysummaryproject.ui.main.weather.WeatherFragment
import ru.summary.mysummaryproject.ui.tabfragments.calendar.CalendarTabFragment
import ru.summary.mysummaryproject.ui.tabfragments.home.HomeTabFragment
import ru.summary.mysummaryproject.ui.tabfragments.weather.WeatherTabFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

object Screens {

    class HomeScreenFragment : SupportAppScreen() {
        private val frag = HomeFragment()
        override fun getFragment() = frag
    }

    class WeatherScreenFragment : SupportAppScreen() {
        private val frag = WeatherFragment()
        override fun getFragment() = frag
    }

    class CalendarScreenFragment : SupportAppScreen() {
        private val frag = CalendarFragment()
        override fun getFragment() = frag
    }

}