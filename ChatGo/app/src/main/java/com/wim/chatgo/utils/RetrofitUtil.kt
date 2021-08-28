package com.wim.chatgo.utils

import com.google.gson.GsonBuilder
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "http://155.230.25.110:5010"
val GSON = GsonBuilder().create()
val RETROFIT = retrofit2.Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create(GSON))
    .build()

fun<T> getService(service: Class<T>): T {
    return RETROFIT.create(service)
}