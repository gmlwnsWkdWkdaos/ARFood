package com.example.arfood

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.arfood.R
import com.unity3d.player.UnityPlayerActivity
import kotlinx.android.synthetic.main.activity_reviewcheck.*
import kotlinx.android.synthetic.main.recyclerview_review_item.*

class ReviewcheckActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reviewcheck)

        //리뷰남기기 btn 클릭시 액티비티 전환
        review_btn.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                val nextintent = Intent(this@ReviewcheckActivity, ReviewwriteActivity::class.java)
                startActivity(nextintent)
            }
        })

    }
}