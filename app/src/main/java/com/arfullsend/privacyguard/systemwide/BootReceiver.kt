package com.arfullsend.privacyguard.systemwide

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class BootReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == Intent.ACTION_BOOT_COMPLETED) {
            // Auto-start the System-Wide service on boot
            val serviceIntent = Intent(context, SystemWideService::class.java)
            context.startForegroundService(serviceIntent)
        }
    }
}