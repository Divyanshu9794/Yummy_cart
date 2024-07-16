package com.example.yummycart

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.yummycart.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private val binding:ActivityLoginBinding by lazy{
        ActivityLoginBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)
        binding.loginbutton.setOnClickListener{
            val  intent = Intent(this,SignupActivity::class.java)
            startActivity(intent)
        }
        binding.donthave.setOnClickListener{
            val  intent = Intent(this,SignupActivity::class.java)
            startActivity(intent)
        }

    }
}