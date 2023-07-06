package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.arcprogress.ArcProgress

class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val btnStart = findViewById<Button>(R.id.btnStart)
        val progress = findViewById<ArcProgress>(R.id.arc_progress)

        btnStart.setOnClickListener {
            progress.setProgress((Math.random() * 100).toFloat())
        }

    }
}
