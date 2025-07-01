package com.example.dropdownmvvm

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dropdownmvvm.model.ServerModel
import com.example.dropdownmvvm.viewmodel.AssessmentViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class ItemListBottomSheet(
    private val items: List<ServerModel>,
    private val onItemSelected: (ServerModel) -> Unit
) : BottomSheetDialogFragment() {

    private lateinit var adapter: ItemAdapter
    private lateinit var viewModel: AssessmentViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = inflater.inflate(R.layout.bottom_sheet_list, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewItems)
        adapter = ItemAdapter(items,onItemSelected)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter

        viewModel = ViewModelProvider(requireActivity())[AssessmentViewModel::class.java]

        viewModel.obsPostResult.observe(viewLifecycleOwner){result ->
            when{
                result.loading->{

                }
                result.data !=null->{

                }
                result.error !=null->{

                }
            }


        }
        val btnsubmit = view.findViewById<Button>(R.id.btnSubmit)
        btnsubmit.setOnClickListener {
            val selectedItems = adapter.itemList.filter {it.isSelected

            }
            selectedItems.forEach {
               Log.d("SelectedItem", "ID: ${it.id}, Name: ${it.name}")
            }

            if (selectedItems.isNotEmpty()) {
                onItemSelected(selectedItems.first()) // or handle multiple
            }
            dismiss()
            viewModel.postSelectedStates(selectedItems)
        }
        return view

    }


}