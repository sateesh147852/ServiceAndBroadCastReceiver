package com.services.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.services.databinding.ActivitySecondBinding
import com.services.utils.Constants.EMAIL
import com.services.utils.Constants.NAME

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra(NAME)
        val email = intent.getStringExtra(EMAIL)

        binding.tvFirstName.text = name
        binding.tvEmail.text = email
    }
}