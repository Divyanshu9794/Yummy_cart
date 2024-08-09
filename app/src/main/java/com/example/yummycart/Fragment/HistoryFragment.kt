package com.example.yummycart.Fragment

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.yummycart.R
import com.example.yummycart.adapter.BuyAgainAdapter
import com.example.yummycart.databinding.FragmentHistoryBinding
import com.example.yummycart.model.OrderDetails
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class HistoryFragment : Fragment() {
    private lateinit var binding: FragmentHistoryBinding
    private lateinit var buyAgainAdapter: BuyAgainAdapter
    private lateinit var database: FirebaseDatabase
    private lateinit var auth: FirebaseAuth
    private lateinit var userId:String
    private var listOfOrderItems:MutableList<OrderDetails> = mutableListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHistoryBinding.inflate(layoutInflater,container,false)

        auth=FirebaseAuth.getInstance()

        database = FirebaseDatabase.getInstance()
        /* retrieve the user order data */

        retrieveBuyHistory()
        setuprecyclerview()

        return binding.root
    }

    private fun retrieveBuyHistory() {

        binding.recentBuyItem.visibility = View.INVISIBLE
        userId = auth.currentUser?.uid?:""

        val buyItemReference : DatabaseReference= database.reference.child("user").child(userId).child("ByHistory")
        val shortingQuery = buyItemReference.orderByChild("currentTime")
        shortingQuery.addListenerForSingleValueEvent(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                for(buySnapshot in snapshot.children){
                    val buyHistoryItem = buySnapshot.getValue(OrderDetails::class.java)
                    buyHistoryItem?.let {
                        listOfOrderItems.add(it)
                    }
                }
                listOfOrderItems.reverse()
                if(listOfOrderItems.isNotEmpty()){
                    setDataInRecentBuyItem()
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })



    }

    private fun setDataInRecentBuyItem() {
        binding.recentBuyItem.visibility = View.VISIBLE
        val recentOrderItem =listOfOrderItems.firstOrNull()
        recentOrderItem?.let {
            with(binding){
                buyAgainFoodName.text = it.foodNames?.firstOrNull()?:""
                buyAgainFoodPrice.text = it.foodPrices?.firstOrNull()?:""
                val image =it.foodImages?.firstOrNull()?:""
                val uri = Uri.parse(image)
                Glide.with(requireContext()).load(uri).into(buyAgainFoodImage)

            }
        }
    }

    private fun setuprecyclerview(){
        val buyAgainFoodName = arrayListOf("Aloo Gobhi","Aloo Paratha","Burger","Dosa")
        val buyAgainFoodprice = arrayListOf("₹115","₹30","₹155","₹120")
        val buyAgainFoodImage = arrayListOf(R.drawable.aloogobhi,R.drawable.alooparatha,R.drawable.burger,R.drawable.dosa)
        buyAgainAdapter=BuyAgainAdapter(buyAgainFoodName,buyAgainFoodprice,buyAgainFoodImage)
        binding.buyagainrecyclerview.adapter=buyAgainAdapter
        binding.buyagainrecyclerview.layoutManager=LinearLayoutManager(requireContext())
    }
    companion object {

    }
}