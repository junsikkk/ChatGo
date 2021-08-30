package com.wim.chatgo.repositories

import com.wim.chatgo.RetrofitResultSet
import com.wim.chatgo.dtos.DropoutTeacherDTO
import com.wim.chatgo.dtos.GetTeacherProfileDTO
import com.wim.chatgo.dtos.SignUpTeacherDTO
import com.wim.chatgo.dtos.UpdateTeacherDTO
import com.wim.chatgo.retrofit_services.ITeacherRetrofitService
import com.wim.chatgo.utils.getService
import com.wim.chatgo.vos.TeacherVo

class TeacherRepository {
    val iTeacherRetrofitService = getService(ITeacherRetrofitService::class.java)

    val signUpTeacherRetrofitResultSet = RetrofitResultSet<SignUpTeacherDTO>()
    val dropoutTeacherRetrofitResultSet = RetrofitResultSet<DropoutTeacherDTO>()
    val updateTeacherRetrofitResultSet = RetrofitResultSet<UpdateTeacherDTO>()
    val getTeacherRetrofitResultSet = RetrofitResultSet<GetTeacherProfileDTO>()

    fun sinUp(teacherVo: TeacherVo): Boolean {
        signUpTeacherRetrofitResultSet.call = iTeacherRetrofitService.signUpTeacher(teacherVo)
        return signUpTeacherRetrofitResultSet.execute()
    }

    fun  dropout(string: String): Boolean {
        dropoutTeacherRetrofitResultSet.call = iTeacherRetrofitService.dropoutTeacher(string)
        return dropoutTeacherRetrofitResultSet.execute()
    }

    fun update(string: String, teacherVo: TeacherVo): Boolean {
        updateTeacherRetrofitResultSet.call = iTeacherRetrofitService.updateTeacher(string, teacherVo)
        return updateTeacherRetrofitResultSet.execute()
    }

    fun getProfile(string: String): Boolean {
        getTeacherRetrofitResultSet.call = iTeacherRetrofitService.getTeacherProfile(string)
        return getTeacherRetrofitResultSet.execute()
    }
}