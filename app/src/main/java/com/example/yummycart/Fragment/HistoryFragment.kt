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
        val buyAgainFoodName = arrayListOf("Aloo Gobhi","Aloo Paratha","Burger","Dosa")
        val buyAgainFoodprice = arrayListOf("₹115","₹30","₹155","₹120")
        val buyAgainFoodImage = arrayListOf(R.drawable.aloogobhi,R.drawable.alooparatha,R.drawable.burger,R.drawable.dosa)
        buyAgainAdapter=BuyAgainAdapter(buyAgainFoodName,buyAgainFoodprice,buyAgainFoodImage)
        binding.buyagainrecyclerview.adapter=buyAgainAdapter
        binding.buyagainrecyclerview.layoutManager=LinearLayoutManager(requireContext())
    }
    companion object {

    }
}