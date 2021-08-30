package com.wim.chatgo.dtos

import com.google.gson.annotations.SerializedName

data class GetTeacherProfileDTO(
    @SerializedName("uid") val uid: String,
    @SerializedName("provider") val provider: String,
    @SerializedName("email") val email: String,
    @SerializedName("password") val password: String,
    @SerializedName("nickname") val nickname: String,
    @SerializedName("academyName") val academyName: String,
    @SerializedName("academyAddress") val academyAddress: String,
    @SerializedName("targetSchool") val targetSchool: String,
    @SerializedName("targetClass") val targetClass: String,
    @SerializedName("subject") val subject: String,
    @SerializedName("studentCount") val studentCount: Int,
    @SerializedName("schoolbusCount") val schoolbusCount: Int,
    @SerializedName("academyCertificate") val academyCertificate: String,
    @SerializedName("buisnessCertificate") val buisnessCertificate: String,
    @SerializedName("subscribed") val subscribed: Boolean,
    @SerializedName("createdAt") val createdAt: String
)
