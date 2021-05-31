package com.example.arfood

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import android.view.MenuItem
import androidx.appcompat.app.AppCompatDelegate
import com.unity3d.player.UnityPlayerActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var backBtn : Long = 0

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        setContentView(R.layout.activity_main)

        val arbtn : Button = findViewById(R.id.arfind_btn)
        val storebtn : Button = findViewById(R.id.storefind_btn)

        //ar버튼 눌렀을때 액티비티 전환
        arbtn.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                val nextintent = Intent(this@MainActivity, UnityPlayerActivity::class.java)
                startActivity(nextintent)
            }
        })
        ar_imgview.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                val nextintent = Intent(this@MainActivity, UnityPlayerActivity::class.java)
                startActivity(nextintent)
            }
        })

        //store 눌렀을때 액티비티 전환
        storebtn.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                val nextintent = Intent(this@MainActivity, SearchActivity::class.java)
                startActivity(nextintent)
            }
        })
        store_imgview.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                val nextintent = Intent(this@MainActivity, SearchActivity::class.java)
                startActivity(nextintent)
            }
        })
    }



    //뒤로가기 종료
    override fun onBackPressed() {
        var curTime : Long = System.currentTimeMillis()
        var gapTime : Long = curTime -backBtn
        if(gapTime >= 0 && gapTime <= 1800){
            super.onBackPressed()
        }
        else{
            backBtn = curTime
            Toast.makeText(this, "뒤로가기를 한 번 더 누르시면 앱이 종료됩니다.", Toast.LENGTH_SHORT).show()
        }
    }


}