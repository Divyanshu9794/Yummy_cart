package com.example.yummycart.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.yummycart.adapter.MenuAdapter
import com.example.yummycart.databinding.FragmentSearchBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding

    private lateinit var  adapter : MenuAdapter
   private lateinit var database: FirebaseDatabase
   private val originalMenuItems = mutableListOf<com.example.yummycart.model.MenuItem>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
//    private val filteredMenuFoodName = mutableListOf<String>()
//    private val filteredMenuFoodPrice = mutableListOf<String>()
//    private val filteredMenuFoodImage = mutableListOf<Int>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSearchBinding.inflate(inflater, container, false)

        retrieveMenuItem()

        //Set up for Search View
        setupSearchView()
        //show all menu items
//        showAllMenu()

        return binding.root
    }

    private fun retrieveMenuItem() {
        database=FirebaseDatabase.getInstance()
        val foodReference:DatabaseReference = database.reference.child("menu")
        foodReference.addListenerForSingleValueEvent(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                for(foodSnapshot in snapshot.children){
                    val menuItem = foodSnapshot.getValue(com.example.yummycart.model.MenuItem::class.java)
                    menuItem?.let {
                        originalMenuItems.add(it)
                    }
                }
                showAllMenu()

            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })

    }

    private fun showAllMenu() {
        val filteredMenuItem =ArrayList(originalMenuItems)
        setAdapter(filteredMenuItem)
    }

    private fun setAdapter(filteredMenuItem: List<com.example.yummycart.model.MenuItem>) {
        adapter = MenuAdapter(filteredMenuItem,requireContext())
        binding.menuRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.menuRecyclerView.adapter = adapter
    }


    private fun setupSearchView() {
        binding.searchView.setOnQueryTextListener(object :SearchView.OnQueryTextListener,
            android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                filterMenuItems(query)
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                filterMenuItems(newText)
                return true
            }
        })
    }

    private fun filterMenuItems(query: String) {

       val filteredMenuItem = originalMenuItems.filter {
           it.foodName?.contains(query, ignoreCase = true)==true
       }
        setAdapter(filteredMenuItem)

    }

    companion object {

    }
}