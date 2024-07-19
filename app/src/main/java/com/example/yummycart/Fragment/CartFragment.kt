package com.example.yummycart.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.yummycart.R
import com.example.yummycart.adapter.CartAdapter
import com.example.yummycart.databinding.FragmentCartBinding

class CartFragment : Fragment() {

    private lateinit var binding:FragmentCartBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCartBinding.inflate(inflater,container,false)

        val foodname = listOf("Burger",
            "Palak Paneer",
            "Chole Bhature",
            "Samosa",
            "Aloo Gobi", "Paneer Tikka", "Masala Dosa",
            "Dal Makhani", "Pani Puri", "Gulab Jamun", "Pav Bhaji", "Malai Kofta", "Bhindi Masala", "Matar Paneer", "Rajma",
            "Baingan Bharta", "Vegetable Biryani", "Aloo Tikki", "Dhokla", "Kadhi Pakora", "Rasam","Idli", "Upma", "Poha", "Aloo Paratha",
            "Dosa", "Pesarattu", "Vada", "Sabudana Khichdi", "Thepla", "Appam", "Misal Pav",
            "Medu Vada", "Chole Kulche", "Puttu", "Moong Dal Cheela", "Besan Chilla", "Pongal", "Vegetable Sandwich",

            "Bread Pakora")

        val Price = listOf("₹150", "₹180", "₹130", "₹90", "₹120", "₹170", "₹110", "₹140", "₹60", "₹50",
            "₹160", "₹190", "₹100", "₹80", "₹70", "₹110", "₹130", "₹50", "₹90", "₹80", "₹60", "₹70",
            "₹110", "₹50", "₹140", "₹160", "₹130", "₹90", "₹100", "₹70", "₹150", "₹120", "₹60", "₹110",
            "₹80", "₹90", "₹100", "₹150", "₹70", "₹60")

        val cartImage = listOf(R.drawable.menu1,R.drawable.menu2,R.drawable.menu3,R.drawable.menu4,
            R.drawable.menu1,R.drawable.menu2,R.drawable.menu3,R.drawable.menu4,
            R.drawable.menu1,R.drawable.menu2,R.drawable.menu3,R.drawable.menu4,
            R.drawable.menu1,R.drawable.menu2,R.drawable.menu3,R.drawable.menu4,
            R.drawable.menu1,R.drawable.menu2,R.drawable.menu3,R.drawable.menu4,
            R.drawable.menu1,R.drawable.menu2,R.drawable.menu3,R.drawable.menu4,
            R.drawable.menu1,R.drawable.menu2,R.drawable.menu3,R.drawable.menu4,
            R.drawable.menu1,R.drawable.menu2,R.drawable.menu3,R.drawable.menu4,
            R.drawable.menu1,R.drawable.menu2,R.drawable.menu3,R.drawable.menu4,
            R.drawable.menu1,R.drawable.menu2,R.drawable.menu3,R.drawable.menu4)

        val adapter= CartAdapter(ArrayList(foodname),ArrayList(Price),ArrayList(cartImage))
        binding.cartrecyclerview.layoutManager = LinearLayoutManager(requireContext())
        binding.cartrecyclerview.adapter = adapter
        return binding.root
    }

    companion object {

    }
}