package com.example.arfood.Adapter


//import com.project.cointerest.Fragment.CoinList
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.net.Uri
import android.os.AsyncTask
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.arfood.Dinning
import com.example.arfood.MapActivity
import com.example.arfood.R
import kotlinx.android.synthetic.main.activity_map.*
import kotlinx.android.synthetic.main.activity_map.view.*
import kotlinx.android.synthetic.main.activity_store.*
import kotlinx.android.synthetic.main.activity_store.view.*
import kotlinx.android.synthetic.main.recyclerview_store_item.view.*
import net.daum.mf.map.api.MapView
import java.net.URL


class StoreRecyclerAdapter(val context: Context, var storeList: ArrayList<Dinning>) :
    RecyclerView.Adapter<StoreRecyclerAdapter.Holder>() {


    override fun getItemCount(): Int = storeList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.recyclerview_store_item, parent, false)
        return Holder(view)
    }


    inner class Holder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        val storeName = itemView?.findViewById<TextView>(R.id.store_name)
        val storeTell = itemView?.findViewById<TextView>(R.id.store_number)

        fun bind(store: Dinning, context: Context) {
            storeName?.text = store.name
            storeTell?.text = store.tel

            itemView.navi_icon.setOnClickListener {
                Intent(context, MapActivity::class.java).apply {
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                }.run { context.startActivity(this) }
            }
        }
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: Holder, position: Int) {

        holder?.bind(storeList[position], context)

    }
}
