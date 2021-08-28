package com.wim.chatgo.utils

import android.view.LayoutInflater
import android.widget.TextView
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.overlay.Marker
import com.naver.maps.map.overlay.OverlayImage
import com.wim.chatgo.R

fun getBookShapeMarker(
    latLng: LatLng,
    layoutInflater: LayoutInflater,
    title: String, snippet: String
): Marker {
    val marker = Marker()
    marker.position = latLng

    val view = layoutInflater.inflate(R.layout.marker_book_shape, null, false)
    view.findViewById<TextView>(R.id.bookShapeTitle).text = title
    view.findViewById<TextView>(R.id.bookShapeSnippet).text = snippet
    marker.icon = OverlayImage.fromView(view)

    return marker
}