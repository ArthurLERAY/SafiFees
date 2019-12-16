package com.example.safifeesv0

import android.os.Build
import androidx.annotation.RequiresApi
import okhttp3.*
import java.io.IOException
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.internal.http2.Http2Reader.Companion.logger
import org.json.JSONObject
import java.math.BigDecimal
import java.net.URL
import java.util.*
import okhttp3.OkHttpClient



open class ModelRAO() {

    fun get(route: String): String {

        val client = OkHttpClient()

        val request = Request.Builder()
            .url("https://www.vogella.com/index.html")
            .build()
            return ""
    }

    fun post(route: String, values: ArrayList<String>) {

        val jsonObject = JSONObject()


        for ((i, item) in values.withIndex()) {
            if ((i % 2) == 0) {
                jsonObject.put(item, values[i+1])
            }
        }
        val body = jsonObject.toString().toRequestBody("application/json; charset=utf-8".toMediaTypeOrNull())

        val okHttpClient = OkHttpClient()
        val request = Request.Builder()
            .method("POST", body)
            .url(route)
            .build()
        okHttpClient.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                println(e)
            }

            override fun onResponse(call: Call, response: Response) {
                println(response)
            }
        })

    }

    fun delete(route: String) {

    }
    fun put(route: String) {

    }

}