package com.moon.mapApplicationTest.data.local.prefs

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.moon.mapApplicationTest.utils.Constants.Companion.PREFERENCE_NAME
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppPreferences @Inject constructor(mContext: Context, private val mGson: Gson) {
    private val PREF_KEY_QUICK_RENTAL = "PREF_KEY_QUICK_RENTAL"

    private var mPrefs: SharedPreferences =
        mContext.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)

}