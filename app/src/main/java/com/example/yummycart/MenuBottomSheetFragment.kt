package com.example.yummycart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.yummycart.adapter.MenuAdapter
import com.example.yummycart.databinding.FragmentMenuBottomSheetBinding
import com.example.yummycart.model.MenuItem
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.firebase.database.FirebaseDatabase


class MenuBottomSheetFragment : BottomSheetDialogFragment() {
    private lateinit var binding : FragmentMenuBottomSheetBinding

    private lateinit var database: FirebaseDatabase
    private lateinit var menuItem: MutableList<MenuItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenuBottomSheetBinding.inflate(inflater,container,false)
        binding.buttonback.setOnClickListener{
            dismiss()
        }
        // Inflate the layout for this fragment
       
        val adapter= MenuAdapter(ArrayList(menufoodname),ArrayList(menuprice),ArrayList(menuImage),requireContext())
        binding.menuRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.menuRecyclerView.adapter = adapter
        return binding.root
    }

    companion object {

    }
}