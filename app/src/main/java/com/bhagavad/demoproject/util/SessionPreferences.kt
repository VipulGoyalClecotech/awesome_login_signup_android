package com.bhagavad.demoproject.util

import android.content.Context
import android.content.SharedPreferences
import android.text.TextUtils


class SessionPreferences {
    companion object {
        val PREFS_NAME = "Demo_Project"


        init {

        }

        fun saveStringPref(
            context: Context,
            key: String?,
            value: String?
        ) {
            val settings: SharedPreferences
            val editor: SharedPreferences.Editor
            settings = context.getSharedPreferences(
                PREFS_NAME,
                Context.MODE_PRIVATE
            )
            editor = settings.edit()
            editor.putString(key, value)
            editor.commit()
        }





        fun saveLongPref(
            context: Context,
            key: String?,
            value: Long
        ) {
            val settings: SharedPreferences
            val editor: SharedPreferences.Editor
            settings = context.getSharedPreferences(
                PREFS_NAME,
                Context.MODE_PRIVATE
            )
            editor = settings.edit()
            editor.putLong(key, value)
            editor.commit()
        }


        fun saveBooleanPref(
            context: Context,
            key: String?,
            value: Boolean
        ) {
            val settings: SharedPreferences
            val editor: SharedPreferences.Editor
            settings = context.getSharedPreferences(
                PREFS_NAME,
                Context.MODE_PRIVATE
            )
            editor = settings.edit()
            editor.putBoolean(key, value)
            editor.commit()
        }


        fun loadStringPref(context: Context, key: String?): String? {
            val settings: SharedPreferences
            settings = context.getSharedPreferences(
                PREFS_NAME,
                Context.MODE_PRIVATE
            )
            return settings.getString(key, "")
        }

        fun loadBooleanPref(
            context: Context,
            key: String?
        ): Boolean {
            val settings: SharedPreferences
            settings = context.getSharedPreferences(
                PREFS_NAME,
                Context.MODE_PRIVATE
            )
            return settings.getBoolean(key, false)
        }





        fun clearAllPreferenceData(context: Context) {
            val settings: SharedPreferences
            settings = context.getSharedPreferences(
                PREFS_NAME,
                Context.MODE_PRIVATE
            )
            val editor = settings.edit()
            editor.clear()
            editor.commit()
        }
    }

}