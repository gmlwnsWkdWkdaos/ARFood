package com.example.arfood

import android.R.layout
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_map.*
import net.daum.mf.map.api.MapView;

class MapActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_map)
        val mapView = MapView(this)
        val mapViewContainer = map_view as ViewGroup
        mapViewContainer.addView(mapView)
    }
}