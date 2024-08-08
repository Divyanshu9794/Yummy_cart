package com.example.yummycart

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.yummycart.databinding.ActivityPayOutBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference

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
    private lateinit var foodItemQuantities:ArrayList<String>
    private lateinit var databaseReference: DatabaseReference
    private lateinit var userId:String

    

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityPayOutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.placemyorder.setOnClickListener{

            val bottomSheetDialog =CongratsBottomSheet()
            bottomSheetDialog.show(supportFragmentManager,"Test")

        }
    }
}