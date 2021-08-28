package com.wim.chatgo.viewmodels

import com.naver.maps.map.overlay.Marker

data class MainViewModel(
    val markers: ArrayList<Marker> = ArrayList()
) {
    fun clearMarkers() {
        for (marker in markers)
            marker.map = null
        markers.clear()
    }
}