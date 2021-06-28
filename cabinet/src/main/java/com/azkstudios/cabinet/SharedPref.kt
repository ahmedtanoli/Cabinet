package com.azkstudios.cabinet

import android.content.Context
import android.content.SharedPreferences

object SharedPref {
    operator fun get(context: Context?, name: String?): SharedPreferences? {
        return context?.getSharedPreferences(name, Context.MODE_PRIVATE)
    }

    operator fun get(context: Context?, name: String?, mode: Int): SharedPreferences? {
        return context?.getSharedPreferences(name, mode)
    }
}