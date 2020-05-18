package ru.summary.mysummaryproject

import android.app.Application
import ru.summary.mysummaryproject.di.global.AppComponent
import ru.summary.mysummaryproject.di.global.DaggerAppComponent

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        appComponent = buildAppComponent()
    }

    private fun buildAppComponent(): AppComponent =
        DaggerAppComponent.builder()
            .context(this)
            .build()

    companion object {
        lateinit var appComponent: AppComponent
    }
}