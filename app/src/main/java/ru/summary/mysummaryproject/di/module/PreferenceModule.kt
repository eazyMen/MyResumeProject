package ru.summary.mysummaryproject.di.module

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.summary.mysummaryproject.data.prefs.PreferenceStorage
import ru.summary.mysummaryproject.data.prefs.PrefsHelper
import javax.inject.Singleton

@Module
class PreferenceModule{

    @Provides
    @Singleton
    fun provideSharedPreference(context: Context): PreferenceStorage = PrefsHelper(context)
}