package com.services.broadcastReceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.services.ui.SecondActivity
import com.services.utils.Constants.EMAIL
import com.services.utils.Constants.NAME
import com.services.utils.Constants.USER_DATA_DOWNLOADED
import com.services.utils.Constants.USER_DATA_SAVED

class UpdateUserDataReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        when(intent.action){

            USER_DATA_DOWNLOADED -> {
                Toast.makeText(context,"Data is downloaded",Toast.LENGTH_SHORT).show()
            }

            USER_DATA_SAVED -> {
                val detailsIntent = Intent(context,SecondActivity::class.java).apply {
                    putExtra(NAME,intent.getStringExtra(NAME))
                    putExtra(EMAIL,intent.getStringExtra(EMAIL))
                }
                context.startActivity(detailsIntent)
                Toast.makeText(context,"Data is saved",Toast.LENGTH_SHORT).show()
            }

        }
    }
}