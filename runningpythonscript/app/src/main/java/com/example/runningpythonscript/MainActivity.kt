package com.example.runningpythonscript

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.chaquo.python.Python
import com.chaquo.python.android.AndroidPlatform

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inputData: EditText = findViewById(R.id.input_data)
        val uploadButton: Button = findViewById(R.id.upload_button)
        val camaraButton: Button = findViewById(R.id.camara_button)

        if (! Python.isStarted()) {
            Python.start( AndroidPlatform(this));
        }

        //this will start python

        //now create python instance
        Python py = Python.getInstance():
    }
}