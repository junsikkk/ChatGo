package com.wim.chatgo.retrofit_services

import com.wim.chatgo.dtos.DropoutStudentDTO
import com.wim.chatgo.dtos.GetStudentProfileDTO
import com.wim.chatgo.dtos.SignUpStudentDTO
import com.wim.chatgo.dtos.UpdateStudentDTO
import com.wim.chatgo.vos.StudentVo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.PUT

interface IStudentRetrofitService {
    @POST("v1/student")
    fun signUpStudent(
        studentVo: StudentVo
    ): Call<SignUpStudentDTO>

    @GET("vl/student/dropout")
    fun dropoutStudent(
        @Header("Authorization") string: String
    ): Call<DropoutStudentDTO>

    @PUT("v1/student/update")
    fun updateStudent(
        @Header("Authorization") string: String,
        studentVo: StudentVo
    ): Call<UpdateStudentDTO>

    @GET("/v1/student/profile")
    fun getStudentProfile(
        @Header("Authorization") string: String
    ): Call<GetStudentProfileDTO>
}