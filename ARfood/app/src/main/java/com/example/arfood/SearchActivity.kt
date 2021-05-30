package com.example.arfood

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import android.view.MenuItem
import android.widget.ImageView
import com.unity3d.player.UnityPlayerActivity
import kotlinx.android.synthetic.main.recyclerview_store_item.*
import kotlinx.android.synthetic.main.activity_store.*
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import kotlinx.android.synthetic.main.activity_map.*
import net.daum.mf.map.api.MapView

class SearchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store)

        review_icon.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                val nextintent = Intent(this@SearchActivity, ReviewcheckActivity::class.java)
                startActivity(nextintent)
            }
        })
        setContentView(R.layout.activity_map)

        val mapView = MapView(this)

        val mapViewContainer = map_view as ViewGroup

        mapViewContainer.addView(mapView)
    }


}