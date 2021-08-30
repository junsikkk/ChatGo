package com.wim.chatgo.dtos

import com.google.gson.annotations.SerializedName

data class GetStudentProfileDTO(
    @SerializedName("uid") val uid: String,
    @SerializedName("provider") val provider: String,
    @SerializedName("email") val email: String,
    @SerializedName("password") val password: String,
    @SerializedName("nickname") val nickname: String,
    @SerializedName("createdAt") val createdAt: String
)
