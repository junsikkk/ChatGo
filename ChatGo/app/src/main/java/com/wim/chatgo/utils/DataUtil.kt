package com.wim.chatgo.utils

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import com.naver.maps.geometry.LatLng
import com.naver.maps.geometry.LatLngBounds
import org.json.JSONException
import org.json.JSONObject
import timber.log.Timber
import java.io.ByteArrayOutputStream
import java.io.InputStream
import java.lang.IllegalArgumentException

const val ERROR_KEY_ERROR_MESSAGE = "errorMessage"
const val ERROR_KEY_ERROR_CODE = "errorCode"
const val ERROR_KEY_ERROR_DESCRIPTION = "errorDescription"

fun parseErrorBody(errorJSONString: String?): HashMap<String, String>? {
    return if (errorJSONString != null) {
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

fun getBytes(inputStream: InputStream): ByteArray {
    val byteBuffer = ByteArrayOutputStream()
    val buffer = ByteArray(1024)

    var len = inputStream.read(buffer)
    while (len != -1) {
        byteBuffer.write(buffer, 0, len)
        len = inputStream.read(buffer)
    }

    return byteBuffer.toByteArray()
}

fun getBytes(bitmap: Bitmap): ByteArray {
    val stream = ByteArrayOutputStream()
    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream)
    return stream.toByteArray()
}

fun getResizedFile(inputStream: InputStream): ByteArray {
    var byteArray = getBytes(inputStream)

    var bitmap = BitmapFactory.decodeStream(inputStream)

    val width = bitmap.width
    val height = bitmap.height

    var tmp = 2
    while (byteArray.size > Math.pow(4.0, 7.0)) {
        bitmap = Bitmap.createScaledBitmap(
            bitmap,
            width / tmp, height / tmp, false
        )
        byteArray = getBytes(bitmap)
        tmp *= 2
    }

    return byteArray
}