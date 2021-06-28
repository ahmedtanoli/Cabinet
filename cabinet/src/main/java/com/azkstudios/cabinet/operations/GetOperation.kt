package com.azkstudios.cabinet.operations

/**
 * Created by Ahmed Zaman on 28/06/2021.
 */

interface GetOperation {
    fun getInt(key: String?, defaultValue: Int): Int
    fun getString(key: String?, defaultValue: String?): String?
    fun getFloat(key: String?, defaultValue: Float): Float
    fun getLong(key: String?, defaultValue: Long): Float
    fun <Model : Any?> getObject(key: String?, modalClass: Class<Model>?): Model?
    fun getBoolean(key: String?, defaultValue: Boolean): Boolean
    fun getStringSet(key: String?, defaultSet: Set<String?>?): Set<String?>?
}
