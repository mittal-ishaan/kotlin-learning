package com.example.myapplication


import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.TimerService

class MainActivity : AppCompatActivity() {

    private val timerReceiver = TimerReceiver()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val intent = Intent(this, TimerService::class.java)
        startService(intent) // This kicks off the timer when the activity is launched. Move to a click handler if needed.
    }

    override fun onResume() {
        super.onResume()
        registerReceiver(timerReceiver, IntentFilter(TimerService.ACTION_TICK))
        registerReceiver(timerReceiver, IntentFilter(TimerService.ACTION_FINISHED))
    }

    override fun onPause() {
        unregisterReceiver(timerReceiver)
        super.onPause()
    }

    private inner class TimerReceiver : BroadcastReceiver() {

        override fun onReceive(context: Context?, intent: Intent?) {
            if (intent == null) return

            when (intent.action) {
                TimerService.ACTION_TICK -> {
                    val timeLeft = intent.getLongExtra(TimerService.TIME_LEFT_KEY, 0)
                    updateUIForTick(timeLeft)
                }
                TimerService.ACTION_FINISHED -> updateUIForTimerFinished()
            }
        }
    }
}