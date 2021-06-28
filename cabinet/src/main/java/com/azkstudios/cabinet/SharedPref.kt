package com.azkstudios.cabinet

import android.content.Context
import android.content.SharedPreferences

/**
 * Created by Ahmed Zaman on 28/06/2021.
 */

object SharedPref {
    operator fun get(context: Context?, name: String?): SharedPreferences? {
        return context?.getSharedPreferences(name, Context.MODE_PRIVATE)
    }

    operator fun get(context: Context?, name: String?, mode: Int): SharedPreferences? {
        return context?.getSharedPreferences(name, mode)
    }
}