package com.example.myapplication.arcprogress

import android.content.Context
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat

class Utils private constructor() {

    companion object {
        fun dp2px(resources: Resources, dp: Float): Float {
            val scale = resources.displayMetrics.density
            return dp * scale + 0.5f
        }

        fun sp2px(resources: Resources, sp: Float): Float {
            val scale = resources.displayMetrics.scaledDensity
            return sp * scale
        }

        fun getBitmap(context: Context, drawableId: Int): Bitmap? {
            val drawable: Drawable? = ContextCompat.getDrawable(context, drawableId)
            return getBitmap(drawable)
        }

        private fun getBitmap(drawable: Drawable?): Bitmap? {
            if (drawable is BitmapDrawable) {
                return drawable.bitmap
            } else if (drawable != null) {
                val bitmap = Bitmap.createBitmap(
                    drawable.intrinsicWidth,
                    drawable.intrinsicHeight,
                    Bitmap.Config.ARGB_8888
                )
                val canvas = Canvas(bitmap)
                drawable.setBounds(0, 0, canvas.width, canvas.height)
                drawable.draw(canvas)
                return bitmap
            }
            return null
        }
    }
}
