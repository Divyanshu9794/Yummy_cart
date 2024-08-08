package com.example.yummycart.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.yummycart.DetailsActivity
import com.example.yummycart.databinding.MenuItemBinding
import com.example.yummycart.model.MenuItem

@Suppress("DEPRECATION")
class MenuAdapter(
    private val menuItems: List<MenuItem>,
    private val requireContext:Context)
    : RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val binding = MenuItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MenuViewHolder(binding)
    }



    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.bind(position)
    }
    override fun getItemCount(): Int =menuItems.size
    inner class MenuViewHolder(private val binding: MenuItemBinding):RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener{
                val position = adapterPosition
                if(position!=RecyclerView.NO_POSITION){
                    openDetailActivity(position)
                }
                //set on click listener to open food details

                val intent = Intent( requireContext,DetailsActivity::class.java )
                intent.putExtra("MenuItemName",menuItemsName.get(position))
                intent.putExtra("MenuItemImage",MenuImage.get(position))
                requireContext.startActivity(intent)
            }
        }

        private fun openDetailActivity(position: Int) {
            val menuItem = menuItems[position]
            val intent = Intent(requireContext,DetailsActivity::class.java).apply {
                putExtra("MenuItemName",menuItem.foodName)
                putExtra("MenuItemImage",menuItem.foodimageurl)
                putExtra("MenuItemDescription",menuItem.fooddescription)
                putExtra("MenuItemIngredients",menuItem.foodingredients)
                putExtra("MenuItemPrice",menuItem.foodprice)
            }
            

        }

        fun bind(position: Int) {
            binding.apply {
                menufoodname.text = menuItemsName[position]
                menuprice.text=menuItemprice[position]
                menuImage.setImageResource(MenuImage[position])


            }

        }


    }

    interface OnClickListener{

        fun onItemClick(position: Int)

    }

}

