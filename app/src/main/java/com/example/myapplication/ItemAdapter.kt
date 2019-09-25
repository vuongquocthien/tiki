package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.layout_item.view.*

class ItemAdapter: RecyclerView.Adapter<ItemAdapter.ItemVh>() {

    private var listData = ArrayList<Item>()

    inner class ItemVh(itemView: View): RecyclerView.ViewHolder(itemView) {

        private val tvName: TextView = itemView.tvName

        internal fun bind(position: Int, data: Item) {
            tvName.text = data.output
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemVh {
        return ItemVh(LayoutInflater.from(parent.context).inflate(R.layout.layout_item, parent, false))
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    override fun onBindViewHolder(holder: ItemVh, position: Int) {
        holder.bind(position, listData[position])
    }

    fun setData(list: List<Item>) {
        listData = ArrayList(list)
        notifyDataSetChanged()
    }

}