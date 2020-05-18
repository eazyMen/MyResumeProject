package ru.summary.mysummaryproject.ui.main.calendar

import android.os.Bundle
import android.view.View
import ru.summary.mysummaryproject.R
import ru.summary.mysummaryproject.ui.global.BaseFragment

class CalendarFragment : BaseFragment(){
    override var layoutId: Int = R.layout.fragment_calendar

    override fun initializeDagger() {

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setTitle(getString(R.string.title_calendar))
    }
}