package com.services.broadcastReceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.services.utils.Constants.USER_DATA_DOWNLOADED
import com.services.utils.Constants.USER_DATA_SAVED

class UpdateUserDataReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        when(intent.action){

            USER_DATA_DOWNLOADED -> {
                Toast.makeText(context,"Data is downloaded",Toast.LENGTH_SHORT).show()
            }

            USER_DATA_SAVED -> {
                Toast.makeText(context,"Data is saved",Toast.LENGTH_SHORT).show()
            }

        }
    }
}