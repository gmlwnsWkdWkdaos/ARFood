package com.example.arfood

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

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