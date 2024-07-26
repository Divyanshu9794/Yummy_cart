package com.example.yummycart.Fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.yummycart.CongratsBottomSheet
import com.example.yummycart.PayOutActivity
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

        val cartImage = listOf(R.drawable.burger,R.drawable.palakpaneer,R.drawable.cholebhature,R.drawable.samosa,R.drawable.aloogobhi,
            R.drawable.paneertikka,R.drawable.masaladosa,R.drawable.dalmakhani,R.drawable.panipuri,
            R.drawable.gulabjamun,R.drawable.pavbhaji,R.drawable.malaikofta,R.drawable.bhindimasala,
            R.drawable.matarpaneer,R.drawable.rajma,R.drawable.baiganbharta,R.drawable.vegetablebiryani,
            R.drawable.alootikki,R.drawable.dhokla,R.drawable.kadhipakora,R.drawable.rasam,
            R.drawable.idli,R.drawable.upma,R.drawable.poha,R.drawable.alooparatha,
            R.drawable.dosa,R.drawable.pesarattu,R.drawable.vada,R.drawable.sabudanakhichadi,
            R.drawable.thepla,R.drawable.appam,R.drawable.misalpaav,R.drawable.meduvada,
            R.drawable.cholekulche,R.drawable.puttu,R.drawable.moongdalchilla,R.drawable.besanchilla,
            R.drawable.pongal,R.drawable.vegetablesandwich,R.drawable.breadpakora)

        val adapter= CartAdapter(ArrayList(foodname),ArrayList(Price),ArrayList(cartImage))
        binding.cartrecyclerview.layoutManager = LinearLayoutManager(requireContext())
        binding.cartrecyclerview.adapter = adapter
        binding.proceedbutton.setOnClickListener{
            val intent = Intent(requireContext(),PayOutActivity::class.java)
            startActivity(intent)
        }

        return binding.root
    }

    companion object {

    }
}