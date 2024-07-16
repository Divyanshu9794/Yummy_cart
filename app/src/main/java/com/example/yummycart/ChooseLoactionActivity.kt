package com.example.yummycart

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.yummycart.databinding.ActivityChooseLoactionBinding
import com.example.yummycart.databinding.ActivitySignupBinding

class ChooseLoactionActivity : AppCompatActivity() {
    private val binding: ActivityChooseLoactionBinding by lazy{
        ActivityChooseLoactionBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val loactionlist = arrayOf("Kanpur","Lucknow","Ghaziabad","Agra","Meerut","Varanasi","Prayagraj","Bareilly",
            "Aligarh","Moradabad","Saharanpur","Gorakhpur","Noida","Firozabad","Jhansi","Muzaffarnagar",
            "Mathura-Vrindavan","Budaun","Rampur","Shahjahanpur","Farrukhabad-Fatehgarh","Ayodhya","Maunath Bhanjan",
            "Hapur","Etawah","Mirzapur-Vindhyachal","Bulandshahr","Sambhal","Amroha","Hardoi","Fatehpur","Raebareli",
            "Orai","Sitapur","Bahraich","Modinagar","Unnao","Jaunpur","Lakhimpur","Hathras","Banda","Pilibhit",
            "Barabanki","Khurja","Gonda","Mainpuri","Lalitpur","Etah","Deoria","Ghazipur","Sultanpur","Azamgarh","Bijnor",
            "Sahaswan","Basti","Chandausi","Akbarpur","Ballia","Tanda","Greater Noida","Shikohabad","Shamli","Awagarh")
        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,loactionlist)
        val autoCompleteTextView = binding.listoflocation
        autoCompleteTextView.setAdapter(adapter)

    }
}