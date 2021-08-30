package com.wim.chatgo.repositories

import com.wim.chatgo.RetrofitResultSet
import com.wim.chatgo.dtos.LoginDTO
import com.wim.chatgo.retrofit_services.ILoginRetrofitService
import com.wim.chatgo.utils.getService
import com.wim.chatgo.vos.LoginVo

class LoginRepository {
    val repositoryResultSet = RetrofitResultSet<LoginDTO>()

    fun login(loginVo: LoginVo): Boolean {
        repositoryResultSet.call = getService(ILoginRetrofitService::class.java)
            .login(loginVo)
        return repositoryResultSet.execute()
    }
}