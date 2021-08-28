package com.wim.chatgo

import com.wim.chatgo.exceptions.RetrofitException
import com.wim.chatgo.utils.parseErrorBody
import retrofit2.Call
import retrofit2.Response
import timber.log.Timber
import java.io.IOException

data class RetrofitResultSet<T>(
    var call: Call<T>? = null,
    var response: Response<T>?= null,
    var responseCode: Int?= null,
    var data: T?= null,
    var errorBody: HashMap<String, String>?= null,
    var isSuccess: Boolean? = null,
) {
    fun execute(): Boolean {
        try {
            response = call?.execute()

            data = response?.body()
            responseCode = response?.code()
            isSuccess = response?.isSuccessful

            errorBody = if(isSuccess == false) parseErrorBody(response?.errorBody().toString()) else null
        } catch (e: IOException) {
            Timber.e(e)
        }

        return isSuccess ?: false
    }
}
