package com.azkstudios.cabinet

import android.content.Context
import androidx.annotation.StringRes

/**
 * Created by Ahmed Zaman on 28/06/2021.
 */

object Cabinet {
    fun open(context: Context?, name: String?): CabinetOperations {
        return CabinetOperations[context, name]
    }

    fun open(context: Context?, name: String?, mode: Int): CabinetOperations {
        return CabinetOperations[context, name, mode]
    }

    fun open(context: Context, @StringRes stringRes: Int): CabinetOperations {
        return CabinetOperations[context, context.getString(stringRes)]
    }

    fun open(context: Context, @StringRes stringRes: Int, mode: Int): CabinetOperations {
        return CabinetOperations[context, context.getString(stringRes), mode]
    }
}