package com.theloungeexperts.moneytalks

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.theloungeexperts.moneytalks.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    private val chatPreviewAdapter = ChatPreviewAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun initChatMenu() {
        binding.apply {
            chatList.layoutManager = LinearLayoutManager(this@HomeActivity)
            chatList.adapter = chatPreviewAdapter
        }
    }
}