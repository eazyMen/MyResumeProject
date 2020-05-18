package ru.summary.mysummaryproject.data.prefs

import android.content.Context
import android.content.SharedPreferences
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty


interface PreferenceStorage {
    var user: String
}

class PrefsHelper(context: Context) : PreferenceStorage {

    private val prefs: SharedPreferences =
        context.getSharedPreferences(PREF_PROFILE, Context.MODE_PRIVATE)

    override var user by StringPrefs(prefs, PREF_GOOD, "")

    companion object {
        const val PREF_GOOD = "PREF_GOOD"
        const val PREF_PROFILE = "PREF_PROFILE"
    }

}

class StringPrefs(
    private val pref: SharedPreferences,
    private val key: String,
    private val defaultValue: String
) : ReadWriteProperty<Any, String> {


    override fun getValue(thisRef: Any, property: KProperty<*>): String {
        return pref.getString(key, defaultValue)!!
    }

    override fun setValue(thisRef: Any, property: KProperty<*>, value: String) {
        pref.edit()
            .putString(key, value)
            .apply()
    }
}

