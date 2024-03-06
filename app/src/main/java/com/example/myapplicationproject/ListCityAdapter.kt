package com.example.myapplicationproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ListCityAdapter(private val listCityAdaptor : ArrayList<City>): RecyclerView.Adapter<ListCityAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    interface OnItemClickCallback {
        fun onItemClicked(data: City)
    }


    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView= itemView.findViewById(R.id.tv_item_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_city, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listCityAdaptor.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo) = listCityAdaptor [position]
        Glide.with(holder.itemView.context)
            .load(photo)
            .into(holder.imgPhoto)
        holder.tvName.text = name
        holder.tvDescription.text = description
        holder.itemView.setOnClickListener{
            Toast.makeText(holder.itemView.context,"Kamu Memilih" + listCityAdaptor[holder.adapterPosition].name,Toast.LENGTH_SHORT).show()
        }
        holder.itemView.setOnClickListener{onItemClickCallback.onItemClicked(listCityAdaptor[holder.adapterPosition])}
    }
    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }
}