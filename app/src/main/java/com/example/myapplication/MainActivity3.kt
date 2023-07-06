package com.example.myapplication

import android.animation.ValueAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.core.content.ContextCompat
import com.dinuscxj.progressbar.CircleProgressBar

class MainActivity3 : AppCompatActivity() {
    private lateinit var mCircleProgressBar: CircleProgressBar
    private lateinit var imageViewNeedle: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        mCircleProgressBar = findViewById(R.id.my_cpb)
        imageViewNeedle = findViewById(R.id.ivThumb)



        mCircleProgressBar.max = 123

        mCircleProgressBar.isDrawBackgroundOutsideProgress = true
        mCircleProgressBar.setProgressBackgroundColor(
            ContextCompat.getColor(this, R.color.colorTransparent)
        )
        mCircleProgressBar.setProgressStartColor(
            ContextCompat.getColor(this, R.color.my_color_thump)
        )
        mCircleProgressBar.setProgressEndColor(
            ContextCompat.getColor(this, R.color.my_color_red)
        )
        mCircleProgressBar.progress = 0



        val animatorValueOnGauge = ValueAnimator.ofInt(0, 100)
        animatorValueOnGauge.addUpdateListener { animation ->
            val progress = animation.animatedValue as Int
            mCircleProgressBar.progress = progress
            imageViewNeedle.rotation = (2.9 * progress).toFloat()
        }
        animatorValueOnGauge.repeatCount = ValueAnimator.INFINITE
        animatorValueOnGauge.duration = 20000
        animatorValueOnGauge.startDelay = 2400
        animatorValueOnGauge.start()
    }
}