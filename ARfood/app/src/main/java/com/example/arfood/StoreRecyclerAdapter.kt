package com.example.arfood


//import com.project.cointerest.Fragment.CoinList
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recyclerview_store_item.view.*


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
