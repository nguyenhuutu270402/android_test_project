package com.example.myapplication

import android.graphics.Color
import android.os.Bundle
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {
    private lateinit var progressBar: ProgressBar
    private lateinit var tvProgress: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        progressBar = findViewById(R.id.progress_bar)
        tvProgress = findViewById(R.id.tvProgress)

        val maxProgress = 300
        val currentProgress = 50

        progressBar.max = maxProgress
        progressBar.progress = currentProgress
        progressBar.progressDrawable.setTint(Color.parseColor("#03A1FE"))

        tvProgress.text = currentProgress.toString()
        tvProgress.setTextColor(Color.parseColor("#04A0FE"))
    }
}
