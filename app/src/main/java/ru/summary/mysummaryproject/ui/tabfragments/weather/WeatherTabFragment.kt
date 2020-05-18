package ru.summary.mysummaryproject.ui.tabfragments.weather

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import moxy.MvpAppCompatFragment
import ru.summary.mysummaryproject.App
import ru.summary.mysummaryproject.R
import ru.summary.mysummaryproject.ui.global.Screens
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import javax.inject.Inject
import javax.inject.Named

class WeatherTabFragment : MvpAppCompatFragment() {

    @Inject
    @field:Named("Weather")
    lateinit var router: Router

    @Inject
    @field:Named("Weather")
    lateinit var navigatorHolder: NavigatorHolder

    lateinit var navigator: Navigator

    override fun onResume() {
        super.onResume()
        navigatorHolder.setNavigator(navigator)
    }

    private val frag = Screens.WeatherScreenFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        App.appComponent.provideWeatherComponent().build().inject(this)
        super.onCreate(savedInstanceState)

        navigator = SupportAppNavigator(activity, childFragmentManager, R.id.weather_container)
        router.replaceScreen(frag)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tab_weather, container, false)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }
}