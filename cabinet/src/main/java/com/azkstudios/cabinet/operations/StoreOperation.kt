package com.azkstudios.cabinet.operations

interface StoreOperation {
    fun add(key: String?, value: Int): StoreOperation?
    fun add(key: String?, value: String?): StoreOperation?
    fun add(key: String?, value: Long): StoreOperation?
    fun add(key: String?, value: Float): StoreOperation?
    fun add(key: String?, value: Boolean): StoreOperation?
    fun add(key: String?, set: Set<String?>?): StoreOperation?
    fun add(key: String?, modal: Any?): StoreOperation?
    fun save()
    fun saveAsync()
}
