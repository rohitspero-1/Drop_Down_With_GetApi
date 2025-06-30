package com.example.dropdownmvvm

import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dropdownmvvm.model.ServerModel

class ItemAdapter(
    private val itemList: List<ServerModel>,
    private val onClick: (ServerModel) -> Unit
) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(private val textView: TextView) : RecyclerView.ViewHolder(textView) {
        fun bind(item: ServerModel) {
            textView.text = item.name
            textView.setOnClickListener { onClick(item) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val textView = TextView(parent.context).apply {
            setPadding(20, 30, 20, 30)
            textSize = 18f
        }
        return ItemViewHolder(textView)
    }

    override fun getItemCount() = itemList.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(itemList[position])
    }
}
