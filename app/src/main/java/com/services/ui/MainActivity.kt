package com.services.ui

import android.content.IntentFilter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.services.broadcastReceiver.UpdateUserDataReceiver
import com.services.databinding.ActivityMainBinding
import com.services.service.DownloadService
import com.services.utils.Constants.USER_DATA_DOWNLOADED
import com.services.utils.Constants.USER_DATA_SAVED

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var updateUserDataReceiver: UpdateUserDataReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        registerUserReceiver()

        binding.btStart.setOnClickListener {
            DownloadService.downloadUserData(this, "Sateesh")
            DownloadService.saveUserInformation(this, "Sateesh", "sateesh147852@gmail.com")
        }
    }

    private fun registerUserReceiver() {
        updateUserDataReceiver = UpdateUserDataReceiver()
        val intentFilter = IntentFilter()
        intentFilter.addAction(USER_DATA_DOWNLOADED)
        intentFilter.addAction(USER_DATA_SAVED)
        registerReceiver(updateUserDataReceiver, intentFilter)
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(updateUserDataReceiver)
    }
}