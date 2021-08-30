package com.wim.chatgo.repositories

import com.wim.chatgo.RetrofitResultSet
import com.wim.chatgo.dtos.DropoutStudentDTO
import com.wim.chatgo.dtos.GetStudentProfileDTO
import com.wim.chatgo.dtos.SignUpStudentDTO
import com.wim.chatgo.dtos.UpdateStudentDTO
import com.wim.chatgo.retrofit_services.IStudentRetrofitService
import com.wim.chatgo.utils.getService
import com.wim.chatgo.vos.StudentVo

class StudentRepository {
    val iStudentRetrofitService = getService(IStudentRetrofitService::class.java)

    val signUpStudentRetrofitResultSet = RetrofitResultSet<SignUpStudentDTO>()
    val dropoutStudentRetrofitResultSet = RetrofitResultSet<DropoutStudentDTO>()
    val updateStudentRetrofitResultSet = RetrofitResultSet<UpdateStudentDTO>()
    val getStudentRetrofitResultSet = RetrofitResultSet<GetStudentProfileDTO>()

    fun sinUp(studentVo: StudentVo): Boolean {
        signUpStudentRetrofitResultSet.call = iStudentRetrofitService.signUpStudent(studentVo)
        return signUpStudentRetrofitResultSet.execute()
    }

    fun  dropout(string: String): Boolean {
        dropoutStudentRetrofitResultSet.call = iStudentRetrofitService.dropoutStudent(string)
        return dropoutStudentRetrofitResultSet.execute()
    }

    fun update(string: String, studentVo: StudentVo): Boolean {
        updateStudentRetrofitResultSet.call = iStudentRetrofitService.updateStudent(string, studentVo)
        return updateStudentRetrofitResultSet.execute()
    }

    fun getProfile(string: String): Boolean {
        getStudentRetrofitResultSet.call = iStudentRetrofitService.getStudentProfile(string)
        return getStudentRetrofitResultSet.execute()
    }
}