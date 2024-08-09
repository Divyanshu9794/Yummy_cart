package com.example.yummycart.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.yummycart.databinding.BuyAgainItemBinding

class BuyAgainAdapter(private val buyAgainFoodname: ArrayList<String>,private val buyAgainFoodprice:ArrayList<String>,
                      private val buyAgainFoodimage:ArrayList<Int>):
    RecyclerView.Adapter<BuyAgainAdapter.BuyagainViewHolder>() {

    override fun onBindViewHolder(holder: BuyagainViewHolder, position: Int) {
        holder.bind(buyAgainFoodname[position],buyAgainFoodprice[position],buyAgainFoodimage[position])
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BuyagainViewHolder {
        val binding = BuyAgainItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return  BuyagainViewHolder(binding)
    }

    override fun getItemCount(): Int =buyAgainFoodname.size
    class BuyagainViewHolder(private val binding: BuyAgainItemBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(foodName: String, foodPrice: String, foodImage: Int) {

            binding.buyAgainFoodName.text =foodName
            binding.buyAgainFoodPrice.text =foodPrice
            binding.buyAgainFoodImage.setImageResource(foodImage)
        }

    }



}