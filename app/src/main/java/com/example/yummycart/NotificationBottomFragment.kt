package com.example.yummycart

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.yummycart.adapter.NotificationAdapter
import com.example.yummycart.databinding.FragmentNotificationBottomBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class NotificationBottomFragment : BottomSheetDialogFragment() {
    private lateinit var binding : FragmentNotificationBottomBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentNotificationBottomBinding.inflate(layoutInflater,container,false)
        val notification= listOf("Your order has been canceled Successfully","Order has been taken by the driver"
        ,"Congrats Your order has been placed")
        val notificationimages = listOf(R.drawable.sademoji,
            R.drawable.truck,R.drawable.congrats)
        val adapter = NotificationAdapter(ArrayList(notification), ArrayList(notificationimages))

        binding.notifiactionRecyclerView.layoutManager=LinearLayoutManager(requireContext())
        binding.notifiactionRecyclerView.adapter=adapter
        return binding.root
    }

    companion object {

    }
}