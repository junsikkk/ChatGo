package com.wim.chatgo.repositories

import com.naver.maps.geometry.LatLng
import com.wim.chatgo.RetrofitResultSet
import com.wim.chatgo.dtos.GetRangeDataDTO
import com.wim.chatgo.retrofit_services.IGetRangeData
import com.wim.chatgo.utils.getService

class GetRangeDataRepository {
    val repositoryResultSet = RetrofitResultSet<ArrayList<GetRangeDataDTO>>()

    fun getRangeData(latLng: LatLng, range: Double): Boolean {
        repositoryResultSet.call = getService(IGetRangeData::class.java)
            .getRangeData(latLng.latitude, latLng.longitude, range)
        return repositoryResultSet.execute()
    }
}