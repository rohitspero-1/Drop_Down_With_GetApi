package com.example.dropdownmvvm

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.dropdownmvvm.viewmodel.AssessmentViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: AssessmentViewModel

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val btnSelectItem = findViewById<Button>(R.id.btnSelectItem)

        viewModel = ViewModelProvider(this)[AssessmentViewModel::class.java]
        btnSelectItem.setOnClickListener {
            viewModel.getStateListFromApi()
        }

        viewModel.obsStateList.observe(this) { result ->
            result.data?.let {
                val bottomSheet = ItemListBottomSheet(result.data) { selectedItem ->
                    Toast.makeText(this, "Selected: ${selectedItem.name}", Toast.LENGTH_SHORT)
                        .show()
                }
                bottomSheet.show(supportFragmentManager, "ItemBottomSheet")
            }
            result.error?.let {
                Toast.makeText(this, "Error: ${result.error.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }
}