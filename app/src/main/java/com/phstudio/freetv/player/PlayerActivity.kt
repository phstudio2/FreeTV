package com.phstudio.freetv.player

import android.annotation.SuppressLint
import android.graphics.Rect
import android.media.AudioManager
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.view.*
import android.widget.TextView
import android.widget.Toast
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import com.phstudio.freetv.R
import com.phstudio.freetv.R.layout
import java.util.*
import kotlin.concurrent.schedule
import kotlin.math.abs


class PlayerActivity : AppCompatActivity() {

    var vLightControl: LightControl? = null
    var vVolumeControl: VolumeControl? = null
    var audioManager: AudioManager? = null
    private var gestureDetector: GestureDetector? = null
    var volume = 0
    var brightness = 0f
    private var ivPlayer: AppCompatImageView? = null
    private var ivFullscreen: AppCompatImageView? = null
    private var tvPlayer: TextView? = null
    private var vvPlayer: VideoView? = null
    private var link: String? = null

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_player)

        vvPlayer = findViewById(R.id.vvPlayer)
        ivPlayer = findViewById(R.id.ivPlayer)
        tvPlayer = findViewById(R.id.tvPlayer)
        ivFullscreen = findViewById(R.id.ivFullscreen)
        vLightControl = findViewById(R.id.lcPlayer)
        vVolumeControl = findViewById(R.id.vcPlayer)

        ivFullscreen?.setOnClickListener{
            setFullScreen()
        }

        val currentBrightness = Settings.System.getInt(
            contentResolver,
            Settings.System.SCREEN_BRIGHTNESS
        )

        setBrightness(currentBrightness)

        initView()

        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }

        val name = intent.getStringExtra("Name")

        link = name

        vvPlayer!!.setVideoPath(link)
        vvPlayer!!.requestFocus()
        vvPlayer!!.start()

        vvPlayer!!.setOnErrorListener { _, _, _ ->
            Toast.makeText(
                this@PlayerActivity,
                getString(R.string.NotStream),
                Toast.LENGTH_SHORT
            ).show()
            finish()
            true
        }
    }


    private fun initView() {
        brightness = PlayerObject.scanForActivity(this)?.window!!.attributes.screenBrightness
        audioManager = this.getSystemService(AUDIO_SERVICE) as AudioManager
        val listener = object : GestureDetector.SimpleOnGestureListener() {
            private var firstTouch = false
            private var changeBrightness = false
            private var changeVolume = false
            override fun onDown(e: MotionEvent): Boolean {
                volume = audioManager!!.getStreamVolume(AudioManager.STREAM_MUSIC)
                brightness = (this@PlayerActivity).window.attributes.screenBrightness
                firstTouch = true
                changeBrightness = false
                changeVolume = false
                return true
            }

            override fun onSingleTapConfirmed(e: MotionEvent): Boolean {
                playOrPause()
                return super.onSingleTapConfirmed(e)
            }

            override fun onScroll(
                me1: MotionEvent,
                me2: MotionEvent,
                distanceA: Float,
                distanceB: Float
            ): Boolean {
                val deltaY = me1.y - me2.y
                if (firstTouch) {
                    if (abs(distanceA) < abs(distanceB)) {
                        if (me2.x > PlayerObject.getScreenWidth(baseContext, true) / 2) {
                            changeVolume = true
                        } else {
                            changeBrightness = true
                        }
                    }
                    firstTouch = false
                }
                if (changeBrightness) {
                    vLightControl!!.visibility = View.VISIBLE
                    Timer().schedule(2000) {
                        vLightControl!!.visibility = View.INVISIBLE
                    }
                    changeBrightness(deltaY)
                } else if (changeVolume) {
                    vVolumeControl!!.visibility = View.VISIBLE
                    Timer().schedule(2000) {
                        vVolumeControl!!.visibility = View.INVISIBLE
                    }
                    changeVolume(deltaY)
                }
                return true
            }

            override fun onDoubleTap(e: MotionEvent): Boolean {
                return true
            }

        }
        gestureDetector = GestureDetector(this@PlayerActivity, listener)
        volume = audioManager!!.getStreamVolume(AudioManager.STREAM_MUSIC)
        brightness = this.window.attributes.screenBrightness
        changeBrightness(0f)
        changeVolume(0f)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        gestureDetector!!.onTouchEvent(event!!)
        return super.onTouchEvent(event)
    }

    fun changeBrightness(deltaY: Float) {
        val window: Window = PlayerObject.scanForActivity(this)!!.window
        val attributes = window.attributes
        val height: Int = PlayerObject.getScreenHeight(applicationContext, false)
        if (brightness == -1.0f) brightness = 0.5f
        var brightness: Float = deltaY * 2 / height * 1.0f + brightness
        if (brightness < 0) {
            brightness = 0f
        }
        if (brightness > 1.0f) brightness = 1.0f
        vLightControl!!.setProgress(brightness)
        attributes.screenBrightness = brightness
        window.attributes = attributes
    }

    fun changeVolume(deltaY: Float) {
        val streamMaxVolume = audioManager!!.getStreamMaxVolume(AudioManager.STREAM_MUSIC)
        val height = PlayerObject.getScreenHeight(applicationContext, false)
        val deltaV = deltaY * 2 / height * streamMaxVolume
        var index = volume + deltaV
        if (index > streamMaxVolume) index = streamMaxVolume.toFloat()
        if (index < 0) {
            index = 0f
        }
        vVolumeControl!!.setProgress(index / streamMaxVolume)
        audioManager!!.setStreamVolume(AudioManager.STREAM_MUSIC, index.toInt(), 0)
    }

    fun playOrPause() {
        if (vvPlayer!!.isPlaying) {
            vvPlayer!!.pause()
            ivPlayer!!.visibility = View.VISIBLE
            tvPlayer!!.text = link.toString()
            tvPlayer!!.visibility = View.VISIBLE
            ivFullscreen!!.visibility = View.VISIBLE
        } else {
            vvPlayer!!.start()
            ivPlayer!!.visibility = View.INVISIBLE
            tvPlayer!!.visibility = View.INVISIBLE
            vVolumeControl!!.visibility = View.INVISIBLE
            vLightControl!!.visibility = View.INVISIBLE
            ivFullscreen!!.visibility = View.INVISIBLE
        }
    }
    private fun setBrightness(brightnessValue: Int) {
        val layoutParams = window.attributes
        layoutParams.screenBrightness = brightnessValue / 255.0f
        window.attributes = layoutParams
    }
    private fun setFullScreen() {
        val fullscreen = true

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            if (fullscreen) {
                window.insetsController?.hide(WindowInsets.Type.statusBars())
            } else {
                window.insetsController?.show(WindowInsets.Type.systemBars())
            }
        } else {
            if (fullscreen) {
                window.setFlags(
                    WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN
                )
            } else {
                window.clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
            }
        }
    }
}