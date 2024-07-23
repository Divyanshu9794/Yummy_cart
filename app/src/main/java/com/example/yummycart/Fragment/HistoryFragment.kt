package com.example.yummycart.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.yummycart.R
import com.example.yummycart.adapter.BuyAgainAdapter
import com.example.yummycart.databinding.FragmentHistoryBinding


class HistoryFragment : Fragment() {
    private lateinit var binding: FragmentHistoryBinding
    private lateinit var buyAgainAdapter: BuyAgainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHistoryBinding.inflate(layoutInflater,container,false)
        setuprecyclerview()

        return binding.root
    }

    private fun setuprecyclerview(){
        val buyAgainFoodName = arrayListOf("food1","food2","food3","food4")
        val buyAgainFoodprice = arrayListOf("₹15","₹20","₹25","₹26")
        val buyAgainFoodImage = arrayListOf(R.drawable.menu1,R.drawable.menu2,R.drawable.menu3,R.drawable.menu4)
        buyAgainAdapter=BuyAgainAdapter(buyAgainFoodName,buyAgainFoodprice,buyAgainFoodImage)
        binding.buyagainrecyclerview.adapter=buyAgainAdapter
        binding.buyagainrecyclerview.layoutManager=LinearLayoutManager(requireContext())
    }
    companion object {

    }
}