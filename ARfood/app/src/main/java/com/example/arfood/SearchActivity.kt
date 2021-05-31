package com.example.arfood

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import kotlin.concurrent.timer

class SearchActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store)
        var storeList = arrayListOf<Dinning>()

        val url = "https://027j0knw0a.execute-api.ap-northeast-2.amazonaws.com/default/tmp_arFood"
        val queue = Volley.newRequestQueue(this)

        val jsonObjectRequest = JsonObjectRequest(Request.Method.GET, url, null,
                Response.Listener { response ->
                    var res = response.getJSONArray("Items")
                    for (i in 0 until res.length()){
                        var item = res.getJSONObject(i)
                        storeList.add(Dinning("${item.get("title")}","${item.get("tel")}"))
                        //Log.d(TAG, "${item.get("tel")}")
                        //Log.d(TAG, "${item.get("title")}")
                    }
                },
                Response.ErrorListener { error ->
                    // TODO: Handle error
                }
        )
        queue.add(jsonObjectRequest)


//        storeList.add(Dinning("명륜진사갈비","111-1111"))
//        storeList.add(Dinning("둘둘치킨","222-2222"))
//        storeList.add(Dinning("큰맘할매순대국","333-3333"))

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