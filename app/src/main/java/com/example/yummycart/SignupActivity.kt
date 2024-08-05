package com.example.yummycart

import android.content.ContentProviderClient
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.yummycart.databinding.ActivitySignupBinding
import com.example.yummycart.databinding.ActivityStartBinding
import com.example.yummycart.model.UserModel
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.database

class SignupActivity : AppCompatActivity() {


    private lateinit var email:String
    private lateinit var password:String
    private lateinit var username:String


    private lateinit var auth :FirebaseAuth
    private lateinit var database: DatabaseReference
    private lateinit var googlegninClient: GoogleSignInClient

    private val binding: ActivitySignupBinding by lazy{
        ActivitySignupBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        //Initializing firebase database

        auth = Firebase.auth

        //initializing firebase auth
        database = Firebase.database.reference

        binding.createaccountbutton.setOnClickListener {
            username = binding.username.text.toString()

            email = binding.editTextTextEmailAddress.text.toString().trim()

            password =binding.password.toString().trim()

            if(email.isBlank() || username.isBlank()||password.isBlank()){
                Toast.makeText(this,"Please Fill all the Details",Toast.LENGTH_SHORT).show()
            }
            else{
                createAccount(email,password)
            }
        }

        binding.alreadyhave.setOnClickListener{
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)

        }


    }

    private fun createAccount(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener {
            task->
            if(task.isSuccessful)
            {
                Toast.makeText(this,"Account Created Successfully",Toast.LENGTH_SHORT).show()
                saveUserData()
                startActivity(Intent(this,LoginActivity::class.java))
                finish()
            }
            else{
                Toast.makeText(this,"Account Creation Failed",Toast.LENGTH_SHORT).show()
                Log.d("Account","createAccount:Failure",task.exception)
            }
        }
    }

    private fun saveUserData() {
        username = binding.username.text.toString()
        password = binding.password.text.toString().trim()
        email = binding.editTextTextEmailAddress.text.toString().trim()

        val user = UserModel(username,email,password)

        val userId = FirebaseAuth.getInstance().currentUser!!.uid


        //save data to firebase data base
        database.child("user").child(userId).setValue(user)
    }
}