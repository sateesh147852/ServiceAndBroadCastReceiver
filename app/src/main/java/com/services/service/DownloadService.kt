package com.services.service

import android.app.IntentService
import android.content.Context
import android.content.Intent
import android.util.Log
import com.services.utils.Constants.EMAIL
import com.services.utils.Constants.NAME
import com.services.utils.Constants.USER_DATA_DOWNLOADED
import com.services.utils.Constants.USER_DATA_SAVED

private const val ACTION_DOWNLOAD = "com.services.service_download"
private const val ACTION_SAVE = "com.services.service_save"

class DownloadService : IntentService("DownloadService") {

    private val TAG = "DownloadService"

    override fun onHandleIntent(intent: Intent?) {
        when (intent?.action) {

            ACTION_DOWNLOAD -> {
                val name = intent.getStringExtra(NAME)
                downloadData(name)
            }

            ACTION_SAVE -> {
                val name = intent.getStringExtra(NAME)
                val email = intent.getStringExtra(EMAIL)
                saveInformation(name, email)
            }
        }
    }

    private fun saveInformation(name: String?, email: String?) {
        Log.i(TAG, "saving: $name$email ${Thread.currentThread().name}")
        Thread.sleep(7000)
        Log.i(TAG, "saved: $name$email")
        val intent = Intent().apply {
            action = USER_DATA_SAVED
            putExtra(NAME, name)
            putExtra(EMAIL, email)
        }
        sendBroadcast(intent)
    }

    private fun downloadData(name: String?) {
        Log.i(TAG, "downloading: $name ${Thread.currentThread().name}")
        Thread.sleep(7000)
        Log.i(TAG, "downloaded: $name")
        val intent = Intent().apply {
            action = USER_DATA_DOWNLOADED
            putExtra(NAME, name)
        }
        sendBroadcast(intent)
        //stopSelf()
    }


    companion object {


        fun downloadUserData(context: Context, name: String) {
            val intent = Intent(context, DownloadService::class.java).apply {
                putExtra(NAME, name)
                action = ACTION_DOWNLOAD
            }
            context.startService(intent)
        }


        fun saveUserInformation(context: Context, name: String, email: String) {
            val intent = Intent(context, DownloadService::class.java).apply {
                putExtra(NAME, name)
                putExtra(EMAIL, email)
                action = ACTION_SAVE
            }
            context.startService(intent)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "onDestroy: ")
    }
}