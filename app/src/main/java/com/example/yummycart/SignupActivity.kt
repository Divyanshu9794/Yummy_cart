package com.example.yummycart

import android.content.ContentProviderClient
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.yummycart.databinding.ActivitySignupBinding
import com.example.yummycart.databinding.ActivityStartBinding
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

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
        binding.alreadyhave.setOnClickListener{
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)

        }
        binding.button4.setOnClickListener{
            val intent = Intent(this,ChooseLoactionActivity::class.java)
            startActivity(intent)

        }

    }
}