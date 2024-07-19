package com.example.yummycart.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.yummycart.databinding.CartItemBinding
import com.example.yummycart.databinding.FragmentProfileBinding

class CartAdapter (private val cartItem:MutableList<String>,private val CartitemPrice:MutableList<String>,private val CartImage: MutableList<Int>): RecyclerView.Adapter<CartAdapter.CartViewHolder>() {
    private val itemQuantity = IntArray(cartItem.size){1}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val binding = CartItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CartViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        holder.bind(position)
    }
    override fun getItemCount(): Int = cartItem.size
    inner class CartViewHolder(private val binding:CartItemBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(position : Int) {
            binding.apply {
                val quantity = itemQuantity[position]
                cartfoodname.text = cartItem[position]
                cartitemprice.text = CartitemPrice[position]
                cartimage.setImageResource(CartImage[position])
                cartItemQuantity.text=quantity.toString()

                minusbutton.setOnClickListener{
                    decreseQuantity(position)

                }
                plusbutton.setOnClickListener {
                    increaseQuantity(position)

                }
                deletebutton.setOnClickListener {
                    var itemposition = adapterPosition
                    if(itemposition!=RecyclerView.NO_POSITION){
                        deleteitem(itemposition)
                    }

                }

            }

        }
        private fun decreseQuantity(position: Int){
            if(itemQuantity[position]>1){
                itemQuantity[position]--
                binding.cartItemQuantity.text = itemQuantity[position].toString()
            }
        }
        private fun deleteitem(position: Int){
            cartItem.removeAt(position)
            CartitemPrice.removeAt(position)
            CartImage.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position,cartItem.size)

        }
        private fun increaseQuantity(position: Int){
            if(itemQuantity[position]<10){
                itemQuantity[position]++
                binding.cartItemQuantity.text = itemQuantity[position].toString()
            }
        }

    }

}