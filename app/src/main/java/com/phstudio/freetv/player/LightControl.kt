package com.phstudio.freetv.player

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Pair
import android.util.TypedValue
import android.view.View
import com.phstudio.freetv.R
import kotlin.math.asin
import kotlin.math.sqrt

class LightControl @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0,
    defStyleRes: Int = 0
) : View(context, attrs, defStyle, defStyleRes) {

    private var layer: RectF? = null
    private var progressMoon = 0f
    private var measureMoon: PathMeasure? = null
    private var quad: Path? = null
    private var circle: Path? = null
    private var circleR = 0f
    private var paint: Paint? = null
    private var paintX: Paint? = null
    private var height = 7f
    private var width = 2f
    private var number = 16
    private val degrees = 360.0f / number
    private val progress = 1.0f / number
    private var numberMax = 0.43f
    private var colorMoon = Color.WHITE
    private var colorWhite = Color.WHITE

    init {
        initAttr(context, attrs)
        layer = RectF()
        measureMoon = PathMeasure()
        quad = Path()
        circle = Path()
        paint = Paint()
        paint!!.color = colorMoon
        paint!!.isAntiAlias = true
        paint!!.style = Paint.Style.FILL
        paintX = Paint()
        paintX!!.isAntiAlias = true
        paintX!!.color = colorMoon
        paintX!!.style = Paint.Style.FILL
        paintX!!.xfermode = PorterDuffXfermode(PorterDuff.Mode.DST_OUT)
        setWillNotDraw(false)
    }

    private fun initAttr(context: Context, attrs: AttributeSet?) {
        val help = context.obtainStyledAttributes(attrs, R.styleable.LightControl)
        height = convert(height)
        width = convert(width)
        height = help.getDimension(R.styleable.LightControl_lcHeight, height)
        width = help.getDimension(R.styleable.LightControl_lcWidth, width)
        number = help.getInteger(R.styleable.LightControl_lcNumber, number)
        numberMax = help.getFloat(R.styleable.LightControl_lcNumberMax, numberMax)
        colorMoon = help.getColor(R.styleable.LightControl_lcColorMoon, colorMoon)
        colorWhite = help.getColor(R.styleable.LightControl_lcColor, colorWhite)
        help.recycle()
    }

    private fun convert(dp: Float): Float {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP, dp,
            context.resources.displayMetrics
        )
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
        circle!!.reset()
        circleR =
            if (newWidth > newHeight) (newHeight - 2 * margin - paddingTop - paddingBottom) / 2.0f else (newWidth - 2 * margin - paddingLeft - paddingRight) / 2.0f
        circle!!.addCircle(layer!!.centerX(), layer!!.centerY(), circleR, Path.Direction.CW)
        measureMoon!!.setPath(circle, false)
    }

    override fun onDraw(wall: Canvas) {
        super.onDraw(wall)
        createDraw(wall)
    }

    private fun createDraw(wall: Canvas) {
        val progress = progressMoon
        val startPoint = floatArrayOf(0f, 0f)
        val endPoint = floatArrayOf(0f, 0f)
        getStart(progress, startPoint)
        getEnd(progress, endPoint)
        quad!!.reset()
        quad!!.moveTo(startPoint[0], startPoint[1])
        val begin = floatArrayOf(startPoint[0], startPoint[1])
        val usePoint = getCPoint(begin, endPoint)
        quad!!.quadTo(usePoint[0], usePoint[1], endPoint[0], endPoint[1])
        val degrees = getAngle(startPoint, endPoint)
        val useRect = RectF(layer)
        useRect.left -= 2f
        useRect.top -= 2f
        useRect.right += 2f
        useRect.bottom += 2f
        quad!!.arcTo(useRect, degrees.first, degrees.second)
        quad!!.moveTo(startPoint[0], startPoint[1])
        quad!!.close()
        wall.saveLayer(layer, null, Canvas.ALL_SAVE_FLAG)
        paint!!.color = colorMoon
        wall.drawPath(circle!!, paint!!)
        wall.drawPath(quad!!, paintX!!)
        wall.restore()
        wall.save()
        wall.translate(layer!!.centerX(), layer!!.centerY())
        val num = number - (progress / this.progress).toInt()
        val half = width / 2
        paint!!.color = colorWhite
        for (i in 0 until num) {
            wall.drawRoundRect(
                RectF(
                    -half,
                    -layer!!.centerY() + paddingTop,
                    half,
                    height - layer!!.centerY() + paddingTop
                ), half, half, paint!!
            )
            wall.rotate(this.degrees)
        }
        wall.restore()
    }

    private fun getStart(progress: Float, point: FloatArray) {
        if (progress <= 0.5) {
            measureMoon!!.getPosTan(measureMoon!!.length * (-0.2f * progress + 0.1f), point, null)
        } else {
            measureMoon!!.getPosTan(measureMoon!!.length * (-0.2f * progress + 1.1f), point, null)
        }
    }

    private fun getEnd(progress: Float, point: FloatArray) {
        if (progress <= 0.1) {
            measureMoon!!.getPosTan(measureMoon!!.length * (-1.0f * progress + 0.1f), point, null)
        } else {
            measureMoon!!.getPosTan(
                measureMoon!!.length * (-7.0f / 9.0f * progress + 9.7f / 9f),
                point,
                null
            )
        }
    }

    private fun getAngle(pointA: FloatArray, pointB: FloatArray): Pair<Float, Float> {
        val centerA = layer!!.centerX()
        val centerB = layer!!.centerY()
        val diffY: Float
        var degrees1 = 0f
        val degrees2: Float
        val startAngle: Float
        val sweepAngle: Float
        if (pointB[0] > centerA && pointB[1] > centerB) {
            degrees1 =
                Math.toDegrees(asin(((pointB[1] - centerB) / circleR).toDouble())).toFloat()
            degrees2 =
                Math.toDegrees(asin(((pointA[1] - centerB) / circleR).toDouble())).toFloat()
            startAngle = degrees1
            sweepAngle = degrees2 - degrees1
        } else {
            if (pointB[0] > centerA) {
                if (pointB[1] < centerB) {
                    diffY = centerB - pointB[1]
                    degrees1 = Math.toDegrees(asin((diffY / circleR).toDouble())).toFloat()
                }
            } else {
                if (pointB[1] < centerB) {
                    diffY = centerB - pointB[1]
                    degrees1 =
                        180 - Math.toDegrees(asin((diffY / circleR).toDouble())).toFloat()
                } else {
                    diffY = pointB[1] - centerB
                    degrees1 =
                        Math.toDegrees(asin((diffY / circleR).toDouble())).toFloat() + 180
                }
            }
            degrees2 =
                Math.toDegrees(asin(((centerB - pointA[1]) / circleR).toDouble())).toFloat()
            startAngle = 360 - degrees1
            sweepAngle = degrees1 - degrees2
        }
        return Pair(startAngle, sweepAngle)
    }

    private fun getCPoint(pointA: FloatArray, pointB: FloatArray): FloatArray {
        val centerA = layer!!.centerX()
        val centerB = layer!!.centerY()
        val distance =
            sqrt(((pointA[0] - pointB[0]) * (pointA[0] - pointB[0]) + (pointA[1] - pointB[1]) * (pointA[1] - pointB[1])).toDouble())
                .toFloat()
        val a = (pointA[0] - pointB[0]) / (pointB[1] - pointA[1])
        val b =
            (pointA[1] + pointB[1]) / 2.0f - (pointA[0] * pointA[0] - pointB[0] * pointB[0]) / 2.0f / (pointB[1] - pointA[1])
        val point = floatArrayOf(0f, 0f)
        val degrees = (1 / sqrt((1 + a * a).toDouble())).toFloat()
        if (a < 0) {
            point[0] = (pointA[0] + pointB[0]) / 2.0f - degrees * distance * numberMax
        } else if (a > 0) {
            if (pointA[0] > centerA && pointA[1] > centerB && pointB[0] > centerA) {
                point[0] = (pointA[0] + pointB[0]) / 2.0f - degrees * distance * numberMax
            } else {
                point[0] = (pointA[0] + pointB[0]) / 2.0f + degrees * distance * numberMax
            }
        } else {
            point[0] = (pointA[0] + pointB[0]) / 2.0f
        }
        point[1] = a * point[0] + b
        return point
    }

    fun setProgress(progress: Float) {
        progressMoon = 1.0f - progress
        postInvalidate()
    }
}