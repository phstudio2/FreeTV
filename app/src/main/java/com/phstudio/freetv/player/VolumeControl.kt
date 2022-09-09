package com.phstudio.freetv.player

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.TypedValue
import android.view.View
import androidx.annotation.StyleableRes
import com.phstudio.freetv.R


class VolumeControl @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0,
    defStyleRes: Int = 0
) : View(context, attrs, defStyle, defStyleRes) {

    private var layer: RectF? = null
    private var progressVolume = 0f
    private var paintVolume: Paint? = null
    private var height = 7f
    private var width = 2f
    private var number = 16
    private val degrees = 360.0f / number
    private val progress = 1.0f / number
    private var icon1: Bitmap? = null
    private var icon2: Bitmap? = null
    private var icon3: Bitmap? = null

    @SuppressLint("ResourceType")
    @StyleableRes
    private var min = R.drawable.ic_min

    @SuppressLint("ResourceType")
    @StyleableRes
    private var medium = R.drawable.ic_medium

    @SuppressLint("ResourceType")
    @StyleableRes
    private var max = R.drawable.ic_max
    private var colorVolume = Color.WHITE

    init {
        initAttr(context, attrs)
        layer = RectF()
        paintVolume = Paint()
        paintVolume!!.isAntiAlias = true
        paintVolume!!.style = Paint.Style.FILL
        paintVolume!!.color = colorVolume
        setWillNotDraw(false)
    }

    private fun initAttr(context: Context, attrs: AttributeSet?) {
        val help = context.obtainStyledAttributes(attrs, R.styleable.VolumeControl)
        height = convert(height)
        width = convert(width)
        height = help.getDimension(R.styleable.VolumeControl_vcHeight, height)
        width = help.getDimension(R.styleable.VolumeControl_vcWidth, width)
        number = help.getInteger(R.styleable.VolumeControl_vcNumber, number)
        min = help.getResourceId(R.styleable.VolumeControl_vcLow, min)
        medium = help.getResourceId(R.styleable.VolumeControl_vcMedium, medium)
        max = help.getResourceId(R.styleable.VolumeControl_vcMax, max)
        colorVolume = help.getColor(R.styleable.VolumeControl_vcColor, colorVolume)
        help.recycle()
    }

    private fun convert(dp: Float): Float {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP, dp,
            context.resources.displayMetrics
        )
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        icon1 = BitmapFactory.decodeResource(resources, min)
        icon2 = BitmapFactory.decodeResource(resources, medium)
        icon3 = BitmapFactory.decodeResource(resources, max)
    }

    override fun onSizeChanged(newWidth: Int, newHeight: Int, oldWidth: Int, oldHeight: Int) {
        super.onSizeChanged(newWidth, newHeight, oldWidth, oldHeight)
        val paddingTop = paddingTop.toFloat()
        val paddingBottom = paddingBottom.toFloat()
        val paddingRight = paddingRight.toFloat()
        val paddingLeft = paddingLeft.toFloat()

        val margin = height + width * 2
        layer!![margin + paddingLeft, margin + paddingTop, newWidth - margin - paddingRight] =
            newHeight - margin - paddingBottom
    }

    override fun onDraw(wall: Canvas) {
        super.onDraw(wall)
        createDraw(wall)
    }

    private fun createDraw(wall: Canvas) {
        val progress = progressVolume
        when (((1 - progress) / 0.33f).toInt()) {
            0 -> {
                wall.drawBitmap(icon1!!, null, layer!!, paintVolume)
            }
            1 -> {
                wall.drawBitmap(icon2!!, null, layer!!, paintVolume)
            }
            else -> {
                wall.drawBitmap(icon3!!, null, layer!!, paintVolume)
            }
        }
        wall.save()
        wall.translate(layer!!.centerX(), layer!!.centerY())
        val num = number - (progress / this.progress).toInt()
        val half = width / 2
        for (i in 0 until num) {
            wall.drawRoundRect(
                RectF(
                    -half,
                    -layer!!.centerY() + paddingTop,
                    half,
                    height - layer!!.centerY() + paddingTop
                ), half, half, paintVolume!!
            )
            wall.rotate(degrees)
        }
        wall.restore()
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        if (icon1 != null && !icon1!!.isRecycled) {
            icon1!!.recycle()
            icon1 = null
        }
        if (icon2 != null && !icon2!!.isRecycled) {
            icon2!!.recycle()
            icon2 = null
        }
        if (icon3 != null && !icon3!!.isRecycled) {
            icon3!!.recycle()
            icon3 = null
        }
    }

    fun setProgress(progress: Float) {
        progressVolume = 1.0f - progress
        postInvalidate()
    }
}