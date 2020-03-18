package com.example.uitest4application.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.uitest4application.R
import com.example.uitest4application.data.model.City
import kotlinx.android.synthetic.main.item_country.view.*

class CountryAdapter (private val onClick:(pos:String)->Unit):RecyclerView.Adapter<CountryAdapter.CountryViewHolder>(){
    private var arr:List<City> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        return CountryViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_country,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return arr.size
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
    holder.bindData()
    }

    private fun getItem(pos:Int)=arr[pos]

    fun updateData(data:List<City>){
        this.arr=data
        notifyDataSetChanged()
    }

    inner class CountryViewHolder(v:View):RecyclerView.ViewHolder(v){
        fun bindData(){
            val item=getItem(adapterPosition)
            itemView.tv_country.text=item.name
            itemView.tv_country.setOnClickListener {
                onClick(item.name)
            }
        }
    }
}