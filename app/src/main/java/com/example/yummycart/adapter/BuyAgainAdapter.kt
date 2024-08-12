package com.example.yummycart.adapter

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.yummycart.databinding.BuyAgainItemBinding

class BuyAgainAdapter(
    private val buyAgainFoodname: MutableList<String>,
    private val buyAgainFoodprice: MutableList<String>,
    private val buyAgainFoodimage: MutableList<String>,
    private var requireContext: Context
) :
    RecyclerView.Adapter<BuyAgainAdapter.BuyagainViewHolder>() {

    override fun onBindViewHolder(holder: BuyagainViewHolder, position: Int) {
        holder.bind(
            buyAgainFoodname[position],
            buyAgainFoodprice[position],
            buyAgainFoodimage[position]
        )
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BuyagainViewHolder {
        val binding =
            BuyAgainItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BuyagainViewHolder(binding)
    }

    override fun getItemCount(): Int = buyAgainFoodname.size
    inner class BuyagainViewHolder(private val binding: BuyAgainItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(foodName: String, foodPrice: String, foodImage: String) {

            binding.buyAgainFoodName.text = foodName
            binding.buyAgainFoodPrice.text = foodPrice
            val uriString = foodImage
            val uri = Uri.parse(uriString)
            Glide.with(requireContext).load(uri).into(binding.buyAgainFoodImage)
        }

    }


}