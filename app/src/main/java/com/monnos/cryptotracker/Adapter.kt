package com.monnos.cryptotracker

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter(val model:MutableList<Model>): RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        return holder.bindView(model[position])
    }

    override fun getItemCount(): Int {
        return model.size
    }
}

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    private val id: TextView = itemView.findViewById(R.id.id)
    private val priceIndexString: TextView = itemView.findViewById(R.id.priceIndexString)

    fun bindView(model: Model){
        id.text = model.id
        priceIndexString.text = model.priceIndexString
    }

}