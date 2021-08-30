package com.wim.chatgo.retrofit_services

import com.wim.chatgo.dtos.DropoutTeacherDTO
import com.wim.chatgo.dtos.GetTeacherProfileDTO
import com.wim.chatgo.dtos.SignUpTeacherDTO
import com.wim.chatgo.dtos.UpdateTeacherDTO
import com.wim.chatgo.vos.TeacherVo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.PUT

interface ITeacherRetrofitService {
    @POST("v1/teacher")
    fun signUpTeacher(
        teacherVo: TeacherVo
    ): Call<SignUpTeacherDTO>

    @GET("vl/teacher/dropout")
    fun dropoutTeacher(
        @Header("Authorization") string: String
    ): Call<DropoutTeacherDTO>

    @PUT("v1/teacher/update")
    fun updateTeacher(
        @Header("Authorization") string: String,
        teacherVo: TeacherVo
    ): Call<UpdateTeacherDTO>

    @GET("/v1/teacher/profile")
    fun getTeacherProfile(
        @Header("Authorization") string: String
    ): Call<GetTeacherProfileDTO>
}