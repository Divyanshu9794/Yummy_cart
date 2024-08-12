package com.example.yummycart

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.yummycart.adapter.RecentBuyAdapter
import com.example.yummycart.databinding.ActivityRecentOrderItemsBinding
import com.example.yummycart.model.OrderDetails
import kotlin.collections.ArrayList as ArrayList1

class RecentOrderItems : AppCompatActivity() {
    private val binding: ActivityRecentOrderItemsBinding by lazy {
        ActivityRecentOrderItemsBinding.inflate(layoutInflater)
    }
    private lateinit var allFoodName: ArrayList1<String>
    private lateinit var allFoodPrice: ArrayList1<String>
    private lateinit var allFoodImage: ArrayList1<String>
    private lateinit var allFoodQuantities: ArrayList1<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        val recentOrderItems = intent.getSerializableExtra("RecentBuyOrderItem") as? ArrayList1<OrderDetails>

        binding.backbutton.setOnClickListener {
            finish()
        }
        if (recentOrderItems != null && recentOrderItems.isNotEmpty()){
                val recentOrderItem = recentOrderItems[0]
                allFoodName = recentOrderItem.foodNames as ArrayList1<String>

                allFoodImage = recentOrderItem.foodImages as ArrayList1<String>
                allFoodPrice = recentOrderItem.foodPrices as ArrayList1<String>
                allFoodQuantities = recentOrderItem.foodQuantities as ArrayList1<Int>


            }


        else {
            // Handle the case of an emptyor null list
            allFoodName = ArrayList1()
            allFoodImage = ArrayList1()
            allFoodPrice = ArrayList1()
            allFoodQuantities = ArrayList1()
        }

        setAdapter()
    }

    private fun setAdapter() {
        val rv = binding.recyclerViewrecentbuy
        rv.layoutManager = LinearLayoutManager(this)

        val adapter = RecentBuyAdapter(this,allFoodName,allFoodImage,allFoodPrice,allFoodQuantities)

        rv.adapter = adapter


    }
}
