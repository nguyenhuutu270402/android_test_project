package com.example.myapplication

import android.animation.ValueAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.dinuscxj.progressbar.CircleProgressBar
import java.text.DecimalFormat

class MainActivity3 : AppCompatActivity() {
    private lateinit var mCircleProgressBar: CircleProgressBar
    private lateinit var imageViewNeedle: ImageView
    private lateinit var tvValueSpeed: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        mCircleProgressBar = findViewById(R.id.my_cpb)
        imageViewNeedle = findViewById(R.id.ivThumb)
        tvValueSpeed = findViewById(R.id.tvValueSpeed)



        mCircleProgressBar.max = 148

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



        val animatorValueOnGauge = ValueAnimator.ofFloat(0f, 120f)
        animatorValueOnGauge.addUpdateListener { animation ->
            val progress = (animation.animatedValue as Float).toInt()
            mCircleProgressBar.progress = progress
            imageViewNeedle.rotation = (2.43 * progress).toFloat()
            val decimalFormat = DecimalFormat("0.00")
            val formattedNumber = decimalFormat.format(animation.animatedValue)
            tvValueSpeed.text = formattedNumber
        }
        animatorValueOnGauge.repeatCount = ValueAnimator.INFINITE
        animatorValueOnGauge.duration = 20000
        animatorValueOnGauge.startDelay = 2400
        animatorValueOnGauge.start()
    }
}