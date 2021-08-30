package com.wim.chatgo.retrofit_services

import com.wim.chatgo.dtos.LoginDTO
import com.wim.chatgo.vos.LoginVo
import retrofit2.Call
import retrofit2.http.POST

interface ILoginRetrofitService {
    @POST("/vi/login")
    fun login(
        loginVo: LoginVo
    ): Call<LoginDTO>
}