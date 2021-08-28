package com.wim.chatgo.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.annotation.UiThread
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.CameraUpdate
import com.naver.maps.map.MapFragment
import com.naver.maps.map.NaverMap
import com.naver.maps.map.OnMapReadyCallback
import com.wim.chatgo.R
import com.wim.chatgo.databinding.ActivityMainBinding
import com.wim.chatgo.repositories.GetRangeDataRepository
import com.wim.chatgo.utils.getBookShapeMarker
import com.wim.chatgo.utils.getCenterPosition
import com.wim.chatgo.utils.getRange
import com.wim.chatgo.viewmodels.MainViewModel
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber

class MainActivity : AppCompatActivity(), OnMapReadyCallback {
    lateinit var activityMainBinding: ActivityMainBinding
    val mainViewModel = MainViewModel()

    val getRangeDataRepository = GetRangeDataRepository()
    val retrofitResultSet = getRangeDataRepository.repositoryResultSet

    lateinit var map: NaverMap

    lateinit var inflater: LayoutInflater

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        inflater = this.layoutInflater

        val fm = supportFragmentManager
        val mapFragment = fm.findFragmentById(R.id.mainMapFragment) as MapFragment?
            ?: MapFragment.newInstance().also {
                fm.beginTransaction().add(R.id.mainMapFragment, it).commit()
            }

        mapFragment.getMapAsync(this)

        activityMainBinding.mainAccountBtn.setOnClickListener {

        }

        activityMainBinding.mainSearchBtn.setOnClickListener {

        }
    }

    @UiThread
    override fun onMapReady(naverMap: NaverMap) {
        map = naverMap

        getBookShapeMarker(
            LatLng(35.860807, 128.592709),
            this.layoutInflater,
            "반월당 아너스제네스", "우리집"
        ).map = naverMap

        naverMap.moveCamera(CameraUpdate.scrollAndZoomTo(LatLng(35.860807, 128.592709), 17.0))

        naverMap.addOnCameraIdleListener {
            mainViewModel.clearMarkers()

            CoroutineScope(Dispatchers.Default).launch {
                getRangeDataRepository.getRangeData(
                    getCenterPosition(naverMap.contentBounds), getRange(naverMap.contentBounds)
                )

                if (retrofitResultSet.isSuccess == true) {
                    Timber.d("retrofitResultSet.data?.size : ${retrofitResultSet.data?.size}")

                    Observable.fromIterable(retrofitResultSet.data)
                        .subscribeOn(Schedulers.computation())
                        .map {
                            getBookShapeMarker(
                                LatLng(it.y.toDouble(), it.x.toDouble()), inflater,
                                it.schoolName, it.field
                            )
                        }
                        .toList()
                        .observeOn(Schedulers.io())
                        .subscribe(
                            {
                                mainViewModel.markers.addAll(it)

                                CoroutineScope(Dispatchers.Main).launch {
                                    for (marker in mainViewModel.markers) {
                                        marker.map = map
                                    }
                                }
                            },
                            {  Timber.e(it) }
                        )
                } else {
                    Timber.d("responseCode : ${retrofitResultSet.responseCode}")
                }
            }
        }
    }
}