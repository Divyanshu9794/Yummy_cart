package com.example.yummycart.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.interfaces.ItemClickListener
import com.denzcoskun.imageslider.models.SlideModel
import com.example.yummycart.R
import com.example.yummycart.adapter.PopularAdapter
import com.example.yummycart.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imageList = ArrayList<SlideModel>()
        imageList.add(SlideModel(R.drawable.banner1,ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.banner2,ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.banner3,ScaleTypes.FIT))

        val imageSlider = binding.imageSlider
        imageSlider.setImageList(imageList)

        imageSlider.setImageList(imageList, ScaleTypes.FIT)

        imageSlider.setItemClickListener(object :ItemClickListener{
            override fun doubleClick(position: Int) {
                TODO("Not yet implemented")
            }

            override fun onItemSelected(position: Int) {
                val itemPosition = imageList[position]
                val itemMessage = "Selected Image  $position"
                Toast.makeText(requireContext(),itemMessage,Toast.LENGTH_SHORT).show()
            }
        })

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

        val popularfoodImages = listOf(R.drawable.menu1,R.drawable.menu2,R.drawable.menu3,R.drawable.menu4,
            R.drawable.menu1,R.drawable.menu2,R.drawable.menu3,R.drawable.menu4,
            R.drawable.menu1,R.drawable.menu2,R.drawable.menu3,R.drawable.menu4,
            R.drawable.menu1,R.drawable.menu2,R.drawable.menu3,R.drawable.menu4,
            R.drawable.menu1,R.drawable.menu2,R.drawable.menu3,R.drawable.menu4,
            R.drawable.menu1,R.drawable.menu2,R.drawable.menu3,R.drawable.menu4,
            R.drawable.menu1,R.drawable.menu2,R.drawable.menu3,R.drawable.menu4,
            R.drawable.menu1,R.drawable.menu2,R.drawable.menu3,R.drawable.menu4,
            R.drawable.menu1,R.drawable.menu2,R.drawable.menu3,R.drawable.menu4,
            R.drawable.menu1,R.drawable.menu2,R.drawable.menu3,R.drawable.menu4)
        val adapter = PopularAdapter(foodname,Price,popularfoodImages)
        binding.popularRecyclerView.layoutManager =LinearLayoutManager(requireContext())
        binding.popularRecyclerView.adapter = adapter






    }



    companion object {

            }
    }
