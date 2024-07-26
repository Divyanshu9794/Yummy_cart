package com.example.yummycart.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.yummycart.R
import com.example.yummycart.adapter.MenuAdapter
import com.example.yummycart.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding

    private lateinit var  adapter : MenuAdapter
    private  val originalMenuFoodName = listOf("Burger",
        "Palak Paneer",
        "Chole Bhature",
        "Samosa",
        "Aloo Gobi", "Paneer Tikka", "Masala Dosa",
        "Dal Makhani", "Pani Puri", "Gulab Jamun", "Pav Bhaji", "Malai Kofta", "Bhindi Masala", "Matar Paneer", "Rajma",
        "Baingan Bharta", "Vegetable Biryani", "Aloo Tikki", "Dhokla", "Kadhi Pakora", "Rasam","Idli", "Upma", "Poha", "Aloo Paratha",
        "Dosa", "Pesarattu", "Vada", "Sabudana Khichdi", "Thepla", "Appam", "Misal Pav",
        "Medu Vada", "Chole Kulche", "Puttu", "Moong Dal Cheela", "Besan Chilla", "Pongal", "Vegetable Sandwich",

        "Bread Pakora")
    private val originalmenuprice = listOf("₹150", "₹180", "₹130", "₹90", "₹120", "₹170", "₹110", "₹140", "₹60", "₹50",
        "₹160", "₹190", "₹100", "₹80", "₹70", "₹110", "₹130", "₹50", "₹90", "₹80", "₹60", "₹70",
        "₹110", "₹50", "₹140", "₹160", "₹130", "₹90", "₹100", "₹70", "₹150", "₹120", "₹60", "₹110",
        "₹80", "₹90", "₹100", "₹150", "₹70", "₹60")

    private val originalmenuImage = listOf(R.drawable.menu1,R.drawable.menu2,R.drawable.menu3,R.drawable.menu4,
        R.drawable.menu1,R.drawable.menu2,R.drawable.menu3,R.drawable.menu4,
        R.drawable.menu1,R.drawable.menu2,R.drawable.menu3,R.drawable.menu4,
        R.drawable.menu1,R.drawable.menu2,R.drawable.menu3,R.drawable.menu4,
        R.drawable.menu1,R.drawable.menu2,R.drawable.menu3,R.drawable.menu4,
        R.drawable.menu1,R.drawable.menu2,R.drawable.menu3,R.drawable.menu4,
        R.drawable.menu1,R.drawable.menu2,R.drawable.menu3,R.drawable.menu4,
        R.drawable.menu1,R.drawable.menu2,R.drawable.menu3,R.drawable.menu4,
        R.drawable.menu1,R.drawable.menu2,R.drawable.menu3,R.drawable.menu4,
        R.drawable.menu1,R.drawable.menu2,R.drawable.menu3,R.drawable.menu4)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    private val filteredMenuFoodName = mutableListOf<String>()
    private val filteredMenuFoodPrice = mutableListOf<String>()
    private val filteredMenuFoodImage = mutableListOf<Int>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(inflater,container,false)
        adapter= MenuAdapter(filteredMenuFoodName,filteredMenuFoodPrice,filteredMenuFoodImage,requireContext())
        binding.menuRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.menuRecyclerView.adapter = adapter


        //Set up for Search View
        setupSearchView()
        //show all menu items
        showAllMenu()

        return binding.root
    }

    private fun showAllMenu() {
        filteredMenuFoodName.clear()
        filteredMenuFoodPrice.clear()
        filteredMenuFoodImage.clear()

        filteredMenuFoodName.addAll(originalMenuFoodName)
        filteredMenuFoodPrice.addAll(originalmenuprice)
        filteredMenuFoodImage.addAll(originalmenuImage)

        adapter.notifyDataSetChanged()
    }

    private fun setupSearchView() {
        binding.searchView.setOnQueryTextListener(object :SearchView.OnQueryTextListener,
            android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                filterMenuItems(query)
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                filterMenuItems(newText)
                return true
            }
        })
    }

    private fun filterMenuItems(query: String) {

        filteredMenuFoodName.clear()
        filteredMenuFoodPrice.clear()
        filteredMenuFoodImage.clear()
        originalMenuFoodName.forEachIndexed{ index ,foodname->
            if(foodname.contains(query.toString(),ignoreCase=true)){
                filteredMenuFoodName.add(foodname)
                filteredMenuFoodPrice.add(originalmenuprice[index])
                filteredMenuFoodImage.add(originalmenuImage[index])

            }
        }
        adapter.notifyDataSetChanged()
    }

    companion object {

    }
}