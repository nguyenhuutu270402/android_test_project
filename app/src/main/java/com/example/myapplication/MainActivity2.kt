package com.example.myapplication

import android.animation.ValueAnimator
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.arcprogress.ArcProgress


class MainActivity2 : AppCompatActivity() {

    private var currentProgress = 50 // Initial value of ArcProgress

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val btnStart = findViewById<Button>(R.id.btnStart)
        val progress = findViewById<ArcProgress>(R.id.arc_progress)

        btnStart.setOnClickListener {
            val newProgress = (Math.random() * 100).toFloat()

            val animator = ValueAnimator.ofInt(currentProgress, newProgress.toInt())
            animator.duration = 500 // Animation duration in milliseconds

            animator.addUpdateListener { valueAnimator ->
                val animatedValue = valueAnimator.animatedValue as Int
                progress.progress = animatedValue.toFloat()
            }

            animator.start()

            currentProgress = newProgress.toInt()
        }
    }
}

