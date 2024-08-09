package com.example.yummycart.adapter

import android.content.Context
import android.gesture.GestureLibrary
import android.graphics.drawable.Drawable
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.yummycart.databinding.CartItemBinding
import com.example.yummycart.databinding.FragmentProfileBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class CartAdapter(
    private val context: Context,
    private val cartItem: MutableList<String>,
    private val cartitemPrice: MutableList<String>,
    private val cartDescription: MutableList<String>,
    private val cartImage: MutableList<String>,
    private val cartQuantity: MutableList<Int>,
    private var cartIngredient:MutableList<String>
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


    //get updated quantities
    fun getUpdatedItemsQuantities(): MutableList<Int> {
        val itemQuantity = mutableListOf<Int>()
        itemQuantity.addAll(cartQuantity)
        return itemQuantity

    }

    inner class CartViewHolder(private val binding: CartItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.apply {
                val quantity = itemQuantity[position]
                cartfoodname.text = cartItem[position]
                cartitemprice.text = cartitemPrice[position]


                val uriString = cartImage[position]
//                Log.d("image", "food Url: $uriString")
                val uri = Uri.parse(uriString)

                Glide.with(context).load(uri).into(cartimage)

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
                cartQuantity[position]= itemQuantity[position]
                binding.cartItemQuantity.text = itemQuantity[position].toString()
            }
        }

        private fun deleteitem(position: Int) {
            val positionRetrieve = position
            getUniqueKeyAtPosition(positionRetrieve){uniqueKey->
                if (uniqueKey!=null){
                    removeItem(position,uniqueKey)
                }
            }

        }

        private fun removeItem(position: Int, uniqueKey: String) {

            if (uniqueKey != null){
                cartItemsReference.child(uniqueKey).removeValue().addOnSuccessListener {
                    cartItem.removeAt(position)
                    cartImage.removeAt(position)
                    cartDescription.removeAt(position)
                    cartQuantity.removeAt(position)
                    cartitemPrice.removeAt(position)
                    cartIngredient.removeAt(position)
                    Toast.makeText(context,"Item Removed Successfully",Toast.LENGTH_SHORT).show()
                    //updating the item quantity

                    itemQuantity= itemQuantity.filterIndexed { index, i -> index!=position }.toIntArray()

                    notifyItemRemoved(position)
                    notifyItemRangeChanged(position,cartItem.size)

                }.addOnFailureListener {
                    Toast.makeText(context,"Failed to Delete",Toast.LENGTH_SHORT).show()
                }
            }
        }

        private fun getUniqueKeyAtPosition(positionRetrieve: Int,onComplete:(String?)->Unit) {
            cartItemsReference.addListenerForSingleValueEvent(object :ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    var uniqueKey:String?=null

                    snapshot.children.forEachIndexed{index, dataSnapshot ->
                        if (index==positionRetrieve) {

                            uniqueKey = dataSnapshot.key
                            return@forEachIndexed
                        }
                    }
                    onComplete(uniqueKey)
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }

            })
        }

        private fun increaseQuantity(position: Int) {
            if (itemQuantity[position] < 10) {
                itemQuantity[position]++
                cartQuantity[position]= itemQuantity[position]
                binding.cartItemQuantity.text = itemQuantity[position].toString()
            }
        }

    }

}