package com.wim.chatgo.repositories

import com.wim.chatgo.RetrofitResultSet
import com.wim.chatgo.dtos.FileUploadDTO
import com.wim.chatgo.retrofit_services.IUpLoadFileRetrofitService
import com.wim.chatgo.utils.getResizedFile
import com.wim.chatgo.utils.getService
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.InputStream

class UpLoadFileRepository {
    val retrofitResultSet = RetrofitResultSet<FileUploadDTO>()

    fun fileUpload(string: String, inputStream: InputStream): Boolean {
        retrofitResultSet.call = getService(IUpLoadFileRetrofitService::class.java)
            .fileUpload(
                string,
                MultipartBody.Part.createFormData(
                    "file",
                    "userImage.jpeg",
                    RequestBody.create(MediaType.parse("image/jpeg"), getResizedFile(inputStream))
                )
            )

        return retrofitResultSet.execute()
    }
}