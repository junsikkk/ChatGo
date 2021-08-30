package com.wim.chatgo.retrofit_services

import com.wim.chatgo.dtos.FileUploadDTO
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.Header
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface IUpLoadFileRetrofitService {
    @Multipart
    @POST("/v1/file/upload")
    fun fileUpload(
        @Header("Authorization") string: String,
        @Part part: MultipartBody.Part
    ): Call<FileUploadDTO>
}