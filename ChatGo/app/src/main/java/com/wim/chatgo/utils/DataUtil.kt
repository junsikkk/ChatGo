package com.wim.chatgo.utils

import com.naver.maps.geometry.LatLng
import com.naver.maps.geometry.LatLngBounds
import org.json.JSONException
import org.json.JSONObject
import timber.log.Timber

const val ERROR_KEY_ERROR_MESSAGE = "errorMessage"
const val ERROR_KEY_ERROR_CODE = "errorCode"
const val ERROR_KEY_ERROR_DESCRIPTION = "errorDescription"

fun parseErrorBody(errorJSONString: String?): HashMap<String, String>? {
    return if(errorJSONString != null) {
        val res = HashMap<String, String>()

        try {
            val jsonObject = JSONObject(errorJSONString)

            res[ERROR_KEY_ERROR_MESSAGE] = jsonObject.getString(ERROR_KEY_ERROR_MESSAGE)
            res[ERROR_KEY_ERROR_CODE] = jsonObject.getString(ERROR_KEY_ERROR_CODE)
            res[ERROR_KEY_ERROR_DESCRIPTION] = jsonObject.getString(ERROR_KEY_ERROR_DESCRIPTION)
        } catch (e: JSONException) {
            Timber.e(e)
        }

        res
    } else null
}

fun toRadian(degree: Double): Double {
    return degree * Math.PI / 180
}

fun toDegree(radian: Double): Double {
    return radian * 180 / Math.PI
}

fun getRange(latLngBounds: LatLngBounds): Double {
    val A = latLngBounds.northEast
    val B = latLngBounds.southEast

    val theta = A.longitude - B.longitude
    var distance =
        Math.sin(toRadian(A.latitude)) * Math.sin(toRadian(B.latitude))
    +
    Math.cos(toRadian(A.latitude)) * Math.cos(toRadian(B.latitude)) * Math.cos(toRadian(theta))

    distance = Math.acos(distance)
    distance = toDegree(distance)
    distance *= 60 * 1.1515 * 1.609344

    return (distance / 2) * 0.8
}

fun getCenterPosition(latLngBounds: LatLngBounds): LatLng {
    val A = latLngBounds.northEast
    val B = latLngBounds.southEast

    return LatLng(
        (A.latitude + B.latitude) / 2,
        (A.longitude + B.longitude) / 2
    )
}