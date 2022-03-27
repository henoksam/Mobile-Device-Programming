package com.example.explicitintent

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_list.view.*

class MyAdapter(var context: Context, var blist:ArrayList<Product>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list,parent,false)
        return MyViewHolder(view)

    }

    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
        holder.itemView.name.text = blist[position].title
        holder.itemView.price.text = blist[position].price.toString()
        holder.itemView.color.text = blist[position].color

        holder.itemView.playout.setOnClickListener{

            val intent = Intent(context, DetailActivity::class.java)

            var res = blist[position].title
            Toast.makeText(context," $res clicked", Toast.LENGTH_LONG).show()


            intent.putExtra("title", blist[position].title)
            intent.putExtra("desc",blist[position].desc)
            intent.putExtra("color",blist[position].color)
            intent.putExtra("price",blist[position].price.toString())
            context.startActivity(intent)
        }


    }

    override fun getItemCount(): Int {
        return blist.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}
