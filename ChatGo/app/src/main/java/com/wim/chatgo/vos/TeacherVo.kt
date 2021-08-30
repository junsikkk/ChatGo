package com.wim.chatgo.vos

data class TeacherVo(
    val provider: String,
    val email: String,
    val password: String,
    val nickname: String,
    val academyName: String,
    val academyAddress: String,
    val targetSchool: String,
    val targetClass: String,
    val subject: String,
    val studentCount: Int,
    val schoolbusCount: Int,
    val academyCertificate: String,
    val buisnessCertificate: String,
    val subscribed: Boolean,
)
