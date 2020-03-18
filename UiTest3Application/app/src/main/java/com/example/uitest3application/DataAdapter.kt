package com.example.uitest3application

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_number.view.*

class DataAdapter (private val onClick:(pos:Int)->Unit):RecyclerView.Adapter<DataAdapter.NumberViewHolder>(){
    private var arr:IntArray=IntArray(0)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumberViewHolder {
        return NumberViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_number,parent,false))
    }

    override fun getItemCount(): Int {
        return arr.size
    }

    override fun onBindViewHolder(holder: NumberViewHolder, position: Int) {
    holder.bindData()
    }

    private fun getItem(pos:Int)=arr[pos]

    fun updateData(data:IntArray){
        this.arr=data
        notifyDataSetChanged()
    }

    inner class NumberViewHolder(v:View):RecyclerView.ViewHolder(v){
        fun bindData(){
            val number=getItem(adapterPosition)
            itemView.tv_number.text="$number"
            itemView.setOnClickListener {
                onClick(number)
            }
        }
    }
}