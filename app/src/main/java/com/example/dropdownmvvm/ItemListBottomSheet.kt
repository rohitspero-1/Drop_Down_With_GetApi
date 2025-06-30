package com.example.dropdownmvvm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dropdownmvvm.model.ServerModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class ItemListBottomSheet(
    private val items: List<ServerModel>,
    private val onItemSelected: (ServerModel) -> Unit
) : BottomSheetDialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = inflater.inflate(R.layout.bottom_sheet_list, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewItems)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = ItemAdapter(items, onItemSelected)
        return view
    }
}