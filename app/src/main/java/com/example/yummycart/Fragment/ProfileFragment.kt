package com.example.yummycart.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.yummycart.R
import com.example.yummycart.databinding.FragmentProfileBinding
import com.example.yummycart.model.UserModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding
    private val auth = FirebaseAuth.getInstance()
    private val database =FirebaseDatabase.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentProfileBinding.inflate(inflater,container,false)
        // Inflate the layout for this fragment
        setUserData()

        binding.editButton.setOnClickListener {
            binding.apply {
                name.isEnabled=true
                address.isEnabled=true
                email.isEnabled=true
                phone.isEnabled=true
                editButton.visibility=View.GONE
            }
        }
        binding.saveInfoButton.setOnClickListener {
            val name =binding.name.text.toString()
            val email= binding.email.text.toString()
            val address=binding.address.text.toString()
            val phone=binding.phone.text.toString()

            updateUserData(name,email,address,phone)
        }

        return binding.root



    }

    private fun updateUserData(name: String, email: String, address: String, phone: String) {

        val userId = auth.currentUser?.uid
        if (userId!=null){
            val userReference = database.getReference("user").child(userId)
            val userData = hashMapOf(
                "name" to name,
                "email" to email,
                "address" to address,
                "phone" to phone
            )
            userReference.setValue(userData).addOnSuccessListener {
                Toast.makeText(requireContext(), "Profile Updated Successfully", Toast.LENGTH_SHORT).show()
            }
                .addOnFailureListener{
                    Toast.makeText(requireContext(), "Profile Update Failed", Toast.LENGTH_SHORT).show()
                }

        }
    }

    private fun setUserData() {
        val userID =auth.currentUser?.uid
        if(userID!=null){
            val userReference = database.getReference("user").child(userID)

            userReference.addListenerForSingleValueEvent(object :ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    if(snapshot.exists()){
                        val userProfile = snapshot.getValue(UserModel::class.java)
                        if(userProfile!=null){
                            binding.name.setText(userProfile.name)
                            binding.address.setText(userProfile.address)
                            binding.email.setText(userProfile.email)
                            binding.phone.setText(userProfile.phone)
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