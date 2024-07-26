package com.example.yummycart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.yummycart.adapter.MenuAdapter
import com.example.yummycart.databinding.FragmentMenuBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class MenuBottomSheetFragment : BottomSheetDialogFragment() {
    private lateinit var binding : FragmentMenuBottomSheetBinding

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
        val menufoodname = listOf("Burger",
            "Palak Paneer",
            "Chole Bhature",
            "Samosa",
            "Aloo Gobi", "Paneer Tikka", "Masala Dosa",
            "Dal Makhani", "Pani Puri", "Gulab Jamun", "Pav Bhaji", "Malai Kofta", "Bhindi Masala", "Matar Paneer", "Rajma",
            "Baingan Bharta", "Vegetable Biryani", "Aloo Tikki", "Dhokla", "Kadhi Pakora", "Rasam","Idli", "Upma", "Poha", "Aloo Paratha",
            "Dosa", "Pesarattu", "Vada", "Sabudana Khichdi", "Thepla", "Appam", "Misal Pav",
            "Medu Vada", "Chole Kulche", "Puttu", "Moong Dal Cheela", "Besan Chilla", "Pongal", "Vegetable Sandwich",

            "Bread Pakora")

        val menuprice = listOf("₹150", "₹180", "₹130", "₹90", "₹120", "₹170", "₹110", "₹140", "₹60", "₹50",
            "₹160", "₹190", "₹100", "₹80", "₹70", "₹110", "₹130", "₹50", "₹90", "₹80", "₹60", "₹70",
            "₹110", "₹50", "₹140", "₹160", "₹130", "₹90", "₹100", "₹70", "₹150", "₹120", "₹60", "₹110",
            "₹80", "₹90", "₹100", "₹150", "₹70", "₹60")

        val menuImage = listOf(R.drawable.menu1,R.drawable.menu2,R.drawable.menu3,R.drawable.menu4,
            R.drawable.menu1,R.drawable.menu2,R.drawable.menu3,R.drawable.menu4,
            R.drawable.menu1,R.drawable.menu2,R.drawable.menu3,R.drawable.menu4,
            R.drawable.menu1,R.drawable.menu2,R.drawable.menu3,R.drawable.menu4,
            R.drawable.menu1,R.drawable.menu2,R.drawable.menu3,R.drawable.menu4,
            R.drawable.menu1,R.drawable.menu2,R.drawable.menu3,R.drawable.menu4,
            R.drawable.menu1,R.drawable.menu2,R.drawable.menu3,R.drawable.menu4,
            R.drawable.menu1,R.drawable.menu2,R.drawable.menu3,R.drawable.menu4,
            R.drawable.menu1,R.drawable.menu2,R.drawable.menu3,R.drawable.menu4,
            R.drawable.menu1,R.drawable.menu2,R.drawable.menu3,R.drawable.menu4)

        val adapter= MenuAdapter(ArrayList(menufoodname),ArrayList(menuprice),ArrayList(menuImage),requireContext())
        binding.menuRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.menuRecyclerView.adapter = adapter
        return binding.root
    }

    companion object {

    }
}