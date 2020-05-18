package ru.summary.mysummaryproject.ui

import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import ru.summary.mysummaryproject.R
import ru.summary.mysummaryproject.ui.global.BaseActivity
import ru.summary.mysummaryproject.ui.tabfragments.calendar.CalendarTabFragment
import ru.summary.mysummaryproject.ui.tabfragments.home.HomeTabFragment
import ru.summary.mysummaryproject.ui.tabfragments.weather.WeatherTabFragment

class MainActivity : BaseActivity(), BottomNavigationView.OnNavigationItemSelectedListener {
    override val layoutId: Int = R.layout.activity_main


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bottomNavigationBar.setOnNavigationItemSelectedListener(this)
        navigateTo(HomeTabFragment())
    }

    override fun initializeDagger() {}// TODO


    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        when (p0.itemId) {
            R.id.menu_home -> {
                navigateTo(HomeTabFragment())
                return true
            }
            R.id.menu_new -> {
                navigateTo(WeatherTabFragment())
                return true
            }
            R.id.menu_search -> {
                navigateTo(CalendarTabFragment())
                return true
            }
        }
        return false
    }

    private fun navigateTo(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.commit()
    }

}
