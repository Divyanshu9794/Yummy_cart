package com.example.yummycart

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.yummycart.databinding.ActivityPayOutBinding
import com.example.yummycart.model.OrderDetails
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlin.time.times

class PayOutActivity : AppCompatActivity() {
    lateinit var binding:ActivityPayOutBinding

    private lateinit var auth: FirebaseAuth
    private lateinit var name :String
    private lateinit var address:String
    private lateinit var phone:String
    private lateinit var totalamount:String
    private lateinit var foodItemName:ArrayList<String>
    private lateinit var foodItemPrice:ArrayList<String>
    private lateinit var foodItemImage:ArrayList<String>
    private lateinit var foodItemDescription:ArrayList<String>
    private lateinit var foodItemIngredient:ArrayList<String>
    private lateinit var foodItemQuantities:ArrayList<Int>
    private lateinit var databaseReference: DatabaseReference
    private lateinit var userId:String



    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityPayOutBinding.inflate(layoutInflater)
        setContentView(binding.root)


        auth= FirebaseAuth.getInstance()
        databaseReference = FirebaseDatabase.getInstance().getReference()
        setUserData()

        //get user details from firebase

        val intent = intent
        foodItemName = intent.getStringArrayListExtra("FoodItemName") as ArrayList<String>

        foodItemPrice= intent.getStringArrayListExtra("FoodItemPrice") as ArrayList<String>
        foodItemImage= intent.getStringArrayListExtra("FoodItemImage") as ArrayList<String>
        foodItemDescription= intent.getStringArrayListExtra("FoodItemDescription") as ArrayList<String>
        foodItemIngredient= intent.getStringArrayListExtra("FoodItemIngredient") as ArrayList<String>
        foodItemQuantities = intent.getIntegerArrayListExtra("FoodItemQuantities") as ArrayList<Int>


        totalamount = calculateTotalAmount().toString()+"₹"
        binding.totalAmount.isEnabled = false
        binding.totalAmount.setText(totalamount)

        binding.backbutton.setOnClickListener {
            finish()
        }





        binding.placemyorder.setOnClickListener{
            //get data from textview
             name = binding.name.text.toString().trim()
             address = binding.address.text.toString().trim()
             phone = binding.phone.text.toString().trim()
             totalamount = binding.totalAmount.text.toString().trim()

            if(name.isBlank() && address.isBlank()){
                Toast.makeText(this, "Please Fill All the Details", Toast.LENGTH_SHORT).show()

            }
            else{
                placeOrder()
            }

            val bottomSheetDialog =CongratsBottomSheet()
            bottomSheetDialog.show(supportFragmentManager,"Test")

        }
    }

    private fun placeOrder() {

        userId  = auth.currentUser?.uid?:""
        val time = System.currentTimeMillis()
        val itemPushKey = databaseReference.child("OrderDetails").push().key
        val orderDetails  =OrderDetails(userId,name,foodItemName,foodItemPrice,foodItemImage,foodItemQuantities,address,phone,time,itemPushKey,false,false)


        val orderReference = databaseReference.child("OrderDetails").child(itemPushKey!!)
        orderReference.setValue(orderDetails).addOnSuccessListener {
            val bottomSheetDialog = CongratsBottomSheet()
            bottomSheetDialog.show(supportFragmentManager,"Test")
            finish()

        }
    }

    private fun calculateTotalAmount(): Int {
        var totalAmount = 0

        // Assuming foodItemPrice and foodItemQuantities are lists of the same size
        for (i in 0 until foodItemPrice.size) {
            val price = foodItemPrice[i]

            // Remove currency symbol if present and convert to integer
            val priceIntValue = if (price.last() == '₹') {
                price.dropLast(1).toInt()
            } else {
                price.toInt()
            }

            // Access quantity for the current item
            val quantity = foodItemQuantities[i]

            // Update total amount
            totalAmount += priceIntValue * quantity
        }

        return totalAmount
    }


    private fun setUserData() {
        val user = auth.currentUser
        if(user!=null){
            val userId = user.uid
            val userReference =databaseReference.child("user").child(userId)
            userReference.addListenerForSingleValueEvent(object :ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    if(snapshot.exists()){
                        val names = snapshot.child("name").getValue(String::class.java)?:""
                        val addresses = snapshot.child("address").getValue(String::class.java)?:""
                        val phones = snapshot.child("phone").getValue(String::class.java)?:""

                        binding.apply {
                            name.setText(names)
                            address.setText(addresses)
                            phone.setText(phones)

                        }
                    }

                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }

            })

        }

    }
}