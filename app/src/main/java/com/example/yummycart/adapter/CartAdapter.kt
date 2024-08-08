package com.example.yummycart.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.yummycart.databinding.CartItemBinding
import com.example.yummycart.databinding.FragmentProfileBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class CartAdapter(
    private val context: Context,
    private val cartItem: MutableList<String>,
    private val cartitemPrice: MutableList<String>,
    private val cartImage: MutableList<Int>,
    private val cartDescription: MutableList<String>,
    private val cartQuantity: MutableList<Int>
) :
    RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    private val auth = FirebaseAuth.getInstance()
    init {
        val database = FirebaseDatabase.getInstance()
        val userId = auth.currentUser?.uid?:""
        val cartItemNumber = cartItem.size


        itemQuantity = IntArray(cartItemNumber){1}
        cartItemsReference= database.reference.child("user").child(userId).child("CartItems")
    }

    companion object{
        private var itemQuantity:IntArray = intArrayOf()
        private lateinit var cartItemsReference: DatabaseReference
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val binding = CartItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CartViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = cartItem.size
    inner class CartViewHolder(private val binding: CartItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.apply {
                val quantity = itemQuantity[position]
                cartfoodname.text = cartItem[position]
                cartitemprice.text = cartitemPrice[position]
                cartimage.setImageResource(cartImage[position])
                cartItemQuantity.text = quantity.toString()

                minusbutton.setOnClickListener {
                    decreseQuantity(position)

                }
                plusbutton.setOnClickListener {
                    increaseQuantity(position)

                }
                deletebutton.setOnClickListener {
                    var itemposition = adapterPosition
                    if (itemposition != RecyclerView.NO_POSITION) {
                        deleteitem(itemposition)
                    }

                }

            }

        }

        private fun decreseQuantity(position: Int) {
            if (itemQuantity[position] > 1) {
                itemQuantity[position]--
                binding.cartItemQuantity.text = itemQuantity[position].toString()
            }
        }

        private fun deleteitem(position: Int) {
            cartItem.removeAt(position)
            cartitemPrice.removeAt(position)
            cartImage.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, cartItem.size)

        }

        private fun increaseQuantity(position: Int) {
            if (itemQuantity[position] < 10) {
                itemQuantity[position]++
                binding.cartItemQuantity.text = itemQuantity[position].toString()
            }
        }

    }

}