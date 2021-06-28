package com.azkstudios.cabinet

import android.content.Context
import android.content.SharedPreferences
import android.os.Build
import android.util.Log
import com.azkstudios.cabinet.operations.Operations
import com.azkstudios.cabinet.operations.StoreOperation
import com.google.gson.Gson

class CabinetOperations : Operations {
    private var sharedPreferences: SharedPreferences?
    private var editor: SharedPreferences.Editor?

    constructor(context: Context?, name: String?) {
        sharedPreferences = SharedPref[context, name]
        editor = sharedPreferences?.edit()
    }

    constructor(context: Context?, name: String?, mode: Int) {
        sharedPreferences = SharedPref[context, name, mode]
        editor = sharedPreferences?.edit()
    }

    override fun add(key: String?, value: Int): StoreOperation {
        if (editor != null) {
            editor!!.putInt(key, value)
        }
        return this
    }

    override fun add(key: String?, value: String?): StoreOperation {
        if (editor != null) {
            editor!!.putString(key, value)
        }
        return this
    }

    override fun add(key: String?, value: Long): StoreOperation {
        if (editor != null) {
            editor!!.putLong(key, value)
        }
        return this
    }

    override fun add(key: String?, value: Float): StoreOperation {
        if (editor != null) {
            editor!!.putFloat(key, value)
        }
        return this
    }

    override fun add(key: String?, value: Boolean): StoreOperation {
        if (editor != null) {
            editor!!.putBoolean(key, value)
        }
        return this
    }

    override fun add(key: String?, set: Set<String?>?): StoreOperation {
        if (editor != null) {
            editor!!.putStringSet(key, set)
        }
        return this
    }

    override fun add(key: String?, modal: Any?): StoreOperation {
        val string: String = Gson().toJson(modal)
        return this.add(key, string)
    }

    override fun save() {
        if (editor != null) {
            editor!!.commit()
        }
    }

    override fun saveAsync() {
        if (editor != null) {
            editor!!.apply()
        }
    }

    override fun clear() {
        if (editor != null) {
            editor!!.clear()
        }
    }

    override fun remove(key: String?) {
        if (editor != null) {
            editor!!.remove(key)
        }
    }

    override fun getInt(key: String?, defaultValue: Int): Int {
        return if (sharedPreferences == null) defaultValue else sharedPreferences!!.getInt(
            key,
            defaultValue
        )
    }

    override fun getString(key: String?, defaultValue: String?): String? {
        return if (sharedPreferences == null) defaultValue else sharedPreferences!!.getString(
            key,
            defaultValue
        )
    }

    override fun getFloat(key: String?, defaultValue: Float): Float {
        return if (sharedPreferences == null) defaultValue else sharedPreferences!!.getFloat(
            key,
            defaultValue
        )
    }

    override fun getLong(key: String?, defaultValue: Long): Float {
        return if (sharedPreferences == null) defaultValue.toFloat() else sharedPreferences!!.getLong(
            key,
            defaultValue
        )
            .toFloat()
    }

    override fun <T> getObject(key: String?, modalClass: Class<T>?): T? {
        return if (sharedPreferences == null) {
            Log.e("CabinetOperations", "sharedpref null")
            null
        } else Gson().fromJson(sharedPreferences!!.getString(key, null), modalClass)
    }

    override fun getBoolean(key: String?, defaultValue: Boolean): Boolean {
        return if (sharedPreferences == null) defaultValue else sharedPreferences!!.getBoolean(
            key,
            defaultValue
        )
    }

    override fun getStringSet(key: String?, defaultSet: Set<String?>?): Set<String?>? {
        return if (sharedPreferences == null) defaultSet else sharedPreferences!!.getStringSet(
            key,
            defaultSet
        )
    }

    companion object {
        operator fun get(context: Context?, name: String?): CabinetOperations {
            return CabinetOperations(context, name)
        }

        operator fun get(context: Context?, name: String?, mode: Int): CabinetOperations {
            return CabinetOperations(context, name, mode)
        }
    }
}

