package com.example.safifeesv0

import java.net.URL

open class ModelRAO() {

    fun get(route: String): String {
        return URL(route).readText()
    }

    fun post(route: String) {

    }

    fun delete(route: String) {

    }
    fun put(route: String) {

    }
}