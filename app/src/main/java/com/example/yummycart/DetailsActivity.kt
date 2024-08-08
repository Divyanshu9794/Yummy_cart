package com.example.yummycart

import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.example.yummycart.databinding.ActivityDetailsBinding
import com.example.yummycart.model.CartItems
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class DetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsBinding
    private var foodName: String? = null
    private var foodImage: String? = null
    private var foodDescription: String? = null
    private var foodIngredients: String? = null
    private var foodPrice: String? = null

    private lateinit var auth : FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        foodName = intent.getStringExtra("MenuItemName")
        foodDescription = intent.getStringExtra("MenuItemDescription")
        foodIngredients = intent.getStringExtra("MenuItemIngredients")
        foodPrice = intent.getStringExtra("MenuItemPrice")
        foodImage = intent.getStringExtra("MenuItemImage")

        with(binding) {
            detailFoodname.text = foodName
            detaildescription.text = foodDescription
            detailIngredients.text = foodIngredients

            Glide.with(this@DetailsActivity).load(Uri.parse(foodImage)).into(detailFoodImage)

        }

        binding.imageButton.setOnClickListener {
            finish()

        }

        binding.AddItemButton.setOnClickListener {
            addItemToCart()
        }


    }

    private fun addItemToCart() {
        val database = FirebaseDatabase.getInstance().reference
        val userId = auth.currentUser?.uid?:""

        val cartItem = CartItems(foodName.toString(),foodPrice.toString(),foodDescription.toString(),foodImage.toString(),1)



        database.child("user").child(userId).child("CartItems").push().setValue(cartItem).addOnSuccessListener {
            Toast.makeText(this,"Item Added Successfully to the cart",Toast.LENGTH_SHORT).show()
        }.addOnFailureListener{
            Toast.makeText(this,"Item Not added to the cart",Toast.LENGTH_SHORT).show()
        }
    }
}