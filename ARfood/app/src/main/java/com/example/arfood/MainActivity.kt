package com.example.arfood

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Base64.DEFAULT
import android.util.Base64.encodeToString
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.unity3d.player.UnityPlayerActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import java.util.*


class MainActivity : AppCompatActivity() {
    var backBtn : Long = 0

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        //getHashKey()

        val arbtn : Button = findViewById(R.id.arfind_btn)
        val storebtn : Button = findViewById(R.id.storefind_btn)

        //ar버튼 눌렀을때 액티비티 전환
        arbtn.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                val nextintent = Intent(this@MainActivity, UnityPlayerActivity::class.java)
                startActivity(nextintent)
            }
        })
        storebtn.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                val nextintent = Intent(this@MainActivity, SearchActivity::class.java)
                startActivity(nextintent)
            }
        })
    }

    private fun getHashKey() {
        var packageInfo: PackageInfo? = null
        try {
            packageInfo = packageManager.getPackageInfo(packageName, PackageManager.GET_SIGNATURES)
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
        }
        if (packageInfo == null) Log.e("KeyHash", "KeyHash:null")
        for (signature in packageInfo!!.signatures) {
            try {
                val md = MessageDigest.getInstance("SHA")
                md.update(signature.toByteArray())
                Log.d("KeyHash", encodeToString(md.digest(), DEFAULT))
            } catch (e: NoSuchAlgorithmException) {
                Log.e("KeyHash", "Unable to get MessageDigest. signature=$signature", e)
            }
        }
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