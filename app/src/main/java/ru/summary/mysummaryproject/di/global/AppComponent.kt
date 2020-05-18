package ru.summary.mysummaryproject.di.global

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.summary.mysummaryproject.di.components.home.HomeComponent
import ru.summary.mysummaryproject.di.components.calendar.CalendarComponent
import ru.summary.mysummaryproject.di.components.weather.WeatherComponent
import ru.summary.mysummaryproject.di.global.user.UserModule
import ru.summary.mysummaryproject.di.module.NavigationModule
import ru.summary.mysummaryproject.di.module.NetworkModule
import ru.summary.mysummaryproject.di.module.PreferenceModule
import javax.inject.Singleton


@Component(
    modules = [
        AppModule::class,
        NetworkModule::class,
        PreferenceModule::class,
        NavigationModule::class,
        UserModule::class
    ]
)

@Singleton
interface AppComponent {

    fun provideHomeComponent(): HomeComponent.Builder
    fun provideCalendarComponent(): CalendarComponent.Builder
    fun provideWeatherComponent(): WeatherComponent.Builder
    //fun userComponentBuilder(): UserComponent.Builder

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun context(context: Context): Builder

        fun build(): AppComponent
    }
}