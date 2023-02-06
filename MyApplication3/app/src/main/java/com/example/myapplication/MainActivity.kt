package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var a: Int
        val sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);

        a = sh.getInt("a", 0);
        val text: TextView = findViewById(R.id.textview)
        if (a == 0) {
            a = 5
            text.setText("5")


        } else {
            a = 0
            text.setText("0")
        }

        var sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE) ?: return
        with(sharedPreferences.edit()) {
            putInt("a", Integer.parseInt(a.toString()))
            apply()
        }
    }
}