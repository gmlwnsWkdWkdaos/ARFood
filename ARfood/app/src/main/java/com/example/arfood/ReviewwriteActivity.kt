package com.example.arfood

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.arfood.R
import com.unity3d.player.UnityPlayerActivity
import kotlinx.android.synthetic.main.activity_reviewwrite.*

class ReviewwriteActivity : AppCompatActivity() {
    private val OPEN_GALLERY = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reviewcheck)

        //리뷰남기기 btn 클릭시 액티비티 전환
        reviewwrite_btn.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                val nextintent = Intent(this@ReviewwriteActivity, ReviewcheckActivity::class.java)
                startActivity(nextintent)
            }
        })

        //사진추가
        image_view1.setOnClickListener{ openGallery() }
    }

    fun openGallery() {
        val intent: Intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.setType("image/*")
        startActivityForResult(intent, OPEN_GALLERY)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?){
        super.onActivityResult(requestCode, resultCode, data)

        if(resultCode == Activity.RESULT_OK){
            if(requestCode == OPEN_GALLERY){
                var currentImageUrl : Uri? = data?.data

                try{
                    val bitmap = MediaStore.Images.Media.getBitmap(contentResolver,currentImageUrl)
                    image_view1.setImageBitmap(bitmap)
                }catch(e:Exception){
                    e.printStackTrace()
                }
            } else {
                Log.d("ActivityResult", "something wrong")
            }
        }

    }
}