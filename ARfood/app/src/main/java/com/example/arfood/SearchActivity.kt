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
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.arfood.Adapter.StoreRecyclerAdapter
import kotlinx.android.synthetic.main.activity_map.*
import net.daum.mf.map.api.MapView

class SearchActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store)


        var storeList = arrayListOf<Dinning>()

        storeList.add(Dinning("명륜진사갈비","111-1111"))
        storeList.add(Dinning("둘둘치킨","222-2222"))
        storeList.add(Dinning("큰맘할매순대국","333-3333"))

        recyclerView = findViewById(R.id.search_content_view!!) as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = StoreRecyclerAdapter(this, storeList)

//        review_icon.setOnClickListener(object : View.OnClickListener{
//            override fun onClick(v: View?) {
//                val nextintent = Intent(this@SearchActivity, ReviewcheckActivity::class.java)
//                startActivity(nextintent)
//            }
//        })


//        review_icon.setOnClickListener {
//            val nextintent = Intent(this@SearchActivity, ReviewcheckActivity::class.java)
//            startActivity(nextintent)
//        }



    }
}