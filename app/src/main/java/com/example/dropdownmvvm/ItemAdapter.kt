package com.example.dropdownmvvm

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.dropdownmvvm.model.ServerModel

class ItemAdapter(
    val itemList: List<ServerModel>,
    private val onItemClick: (ServerModel) -> Unit
) : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.txtName)
        val checkBox: CheckBox = itemView.findViewById(R.id.chkName)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.oneitem, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList[position]
        holder.textView.text = item.name
        holder.checkBox.isChecked = item.isSelected

        holder.itemView.setOnClickListener {
            onItemClick(item)
        }

        holder.checkBox.setOnCheckedChangeListener { _, isChecked ->
            item.isSelected = isChecked
        }

    }

    override fun getItemCount(): Int = itemList.size
}