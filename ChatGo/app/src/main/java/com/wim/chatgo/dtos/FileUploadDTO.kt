package com.wim.chatgo.dtos

import com.google.gson.annotations.SerializedName

data class FileUploadDTO(
    @SerializedName("filename") val fileName: String
)