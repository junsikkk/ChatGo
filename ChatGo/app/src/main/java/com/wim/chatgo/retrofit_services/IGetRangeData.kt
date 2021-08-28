package com.wim.chatgo.retrofit_services

import com.wim.chatgo.dtos.GetRangeDataDTO
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface IGetRangeData {
    @GET("/api/v1/range")
    fun getRangeData(
        @Header("latitude") latitude: Double,
        @Header("longitude") longitude: Double,
        @Header("range") range: Double
    ): Call<ArrayList<GetRangeDataDTO>>

    @GET("/api/v1/range{regin1}")
    fun getRangeData(
        @Header("latitude") latitude: Double,
        @Header("longitude") longitude: Double,
        @Header("range") range: Double,
        @Path("regin1") regin1: String,
    ): Call<ArrayList<GetRangeDataDTO>>

    @GET("/api/v1/range{region1}/{regin2}")
    fun getRangeData(
        @Header("latitude") latitude: Double,
        @Header("longitude") longitude: Double,
        @Header("range") range: Double,
        @Path("regin1") regin1: String,
        @Path("regin2") regin2: String,
    ): Call<ArrayList<GetRangeDataDTO>>
}