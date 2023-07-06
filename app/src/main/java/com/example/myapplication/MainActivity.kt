package com.example.myapplication


import android.animation.ValueAnimator
import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.dinuscxj.progressbar.CircleProgressBar

class MainActivity : AppCompatActivity() {
    private lateinit var mCircleProgressBar: CircleProgressBar
    private lateinit var mCircleProgressBarShadowHide: CircleProgressBar
    private lateinit var imageViewNeedle: ImageView
    private lateinit var textViewCurrentDbCPB: TextView
    private val textViewCPBLabels = arrayOfNulls<TextView>(9)
    private val textViewCPBLabelValues = intArrayOf(0, 20, 30, 50, 60, 70, 90, 100, 120)
    private lateinit var mRelativeLayoutGaugeCurrentDb: RelativeLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mRelativeLayoutGaugeCurrentDb = findViewById(R.id.relativeLayoutGaugeCurrentDb)
        imageViewNeedle = findViewById(R.id.imageViewNeedle)
        textViewCurrentDbCPB = findViewById(R.id.textViewCurrentDbCPB)
        textViewCPBLabels[0] = findViewById(R.id.textView0CPB)
        textViewCPBLabels[1] = findViewById(R.id.textView20CPB)
        textViewCPBLabels[2] = findViewById(R.id.textView30CPB)
        textViewCPBLabels[3] = findViewById(R.id.textView50CPB)
        textViewCPBLabels[4] = findViewById(R.id.textView60CPB)
        textViewCPBLabels[5] = findViewById(R.id.textView70CPB)
        textViewCPBLabels[6] = findViewById(R.id.textView90CPB)
        textViewCPBLabels[7] = findViewById(R.id.textView100CPB)
        textViewCPBLabels[8] = findViewById(R.id.textView120CPB)
        mCircleProgressBar = findViewById(R.id.my_cpb)
//        mCircleProgressBarShadowHide = findViewById(R.id.my_cpb_shadow_hide)
        mCircleProgressBar.max = 165
//        mCircleProgressBarShadowHide.max = 165
        mCircleProgressBar.isDrawBackgroundOutsideProgress = true
        mCircleProgressBar.setProgressBackgroundColor(
            ContextCompat.getColor(this@MainActivity, R.color.colorBackground)
        )
        mCircleProgressBar.setProgressStartColor(
            ContextCompat.getColor(this@MainActivity, R.color.colorCircularProgressBarBackground)
        )
        mCircleProgressBar.setProgressEndColor(
            ContextCompat.getColor(this@MainActivity, R.color.colorCircularProgressBarBackground)
        )
        mCircleProgressBar.progress = 0

        mRelativeLayoutGaugeCurrentDb.visibility = View.INVISIBLE
        imageViewNeedle.visibility = View.INVISIBLE
        for (i in 0..8) {
            textViewCPBLabels[i]?.setTextColor(
                ContextCompat.getColor(
                    this@MainActivity,
                    R.color.colorBackground
                )
            )
        }

        val animatorGauge = ValueAnimator.ofInt(0, 121)
        animatorGauge.addUpdateListener { animation ->
            val progress = animation.animatedValue as Int
            mCircleProgressBar.progress = progress
        }
        animatorGauge.repeatCount = 0
        animatorGauge.duration = 1200
        animatorGauge.start()

        val animatorText = ValueAnimator.ofInt(0, 9)
        animatorText.addUpdateListener { animation ->
            val i = animation.animatedValue as Int
            if (i >= 0 && i < 9)
                textViewCPBLabels[i]?.setTextColor(
                    ContextCompat.getColor(
                        this@MainActivity,
                        R.color.colorActiveGaugeText
                    )
                )
            if (i > 0)
                textViewCPBLabels[i - 1]?.setTextColor(
                    ContextCompat.getColor(
                        this@MainActivity,
                        R.color.colorNotActiveGaugeText
                    )
                )
            if (i == 9) {
                imageViewNeedle.visibility = View.VISIBLE
                mRelativeLayoutGaugeCurrentDb.visibility = View.VISIBLE
                imageViewNeedle.rotation = 0f
                mCircleProgressBar.isDrawBackgroundOutsideProgress = true
                mCircleProgressBar.setProgressBackgroundColor(
                    ContextCompat.getColor(this@MainActivity, R.color.colorCircularProgressBarBackground)
                )
                mCircleProgressBar.setProgressStartColor(
                    ContextCompat.getColor(this@MainActivity, R.color.colorTransparent)
                )
                mCircleProgressBar.setProgressEndColor(
                    ContextCompat.getColor(this@MainActivity, R.color.colorTransparent)
                )
                mCircleProgressBar.progress = 0
            }
        }
        animatorText.repeatCount = 0
        animatorText.duration = 800
        animatorText.startDelay = 1500
        animatorText.start()

        val animatorValueOnGauge = ValueAnimator.ofInt(50, 2)
        animatorValueOnGauge.addUpdateListener { animation ->
            val progress = animation.animatedValue as Int
            mCircleProgressBar.progress = progress
//            mCircleProgressBarShadowHide.progress = progress
            imageViewNeedle.rotation = (2.19166667 * progress).toFloat()
            textViewCurrentDbCPB.text = String.format("%.2f", progress.toFloat())
            for (i in 0..8) {
                if (textViewCPBLabelValues[i] < progress)
                    textViewCPBLabels[i]?.setTextColor(
                        ContextCompat.getColor(
                            this@MainActivity,
                            R.color.colorActiveGaugeText
                        )
                    )
                else
                    textViewCPBLabels[i]?.setTextColor(
                        ContextCompat.getColor(
                            this@MainActivity,
                            R.color.colorNotActiveGaugeText
                        )
                    )
            }
        }
        animatorValueOnGauge.repeatCount = ValueAnimator.INFINITE
        animatorValueOnGauge.duration = 2000
        animatorValueOnGauge.startDelay = 2400
        animatorValueOnGauge.start()
    }
}


