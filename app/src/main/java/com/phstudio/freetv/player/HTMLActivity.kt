package com.phstudio.freetv.player

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import com.phstudio.freetv.R

class HTMLActivity : AppCompatActivity() {

    private var wvHtml: WebView? = null

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_html)

        val position = intent.getIntExtra("TV", 0)
        val name = intent.getStringArrayExtra("Name")

        val link = name!![position]

        wvHtml = findViewById<View>(R.id.wvHtml) as WebView
        wvHtml!!.webViewClient = WebViewClient()
        wvHtml!!.webChromeClient = MyChrome()
        val webSettings = wvHtml!!.settings
        webSettings.javaScriptEnabled = true
        webSettings.cacheMode
        //webSettings.setAppCacheEnabled(true)
        if (savedInstanceState == null) {
            wvHtml!!.loadUrl(link.toString())
        }
    }

    private inner class MyChrome : WebChromeClient() {
        private var customView: View? = null
        private var customViewCallback: CustomViewCallback? = null
        private var originalOrientation = 0
        private var originalSystemUiVisibility = 0
        override fun getDefaultVideoPoster(): Bitmap? {
            return if (customView == null) {
                null
            } else BitmapFactory.decodeResource(applicationContext.resources, 2130837573)
        }

        override fun onHideCustomView() {
            (window.decorView as FrameLayout).removeView(customView)
            customView = null
            window.decorView.systemUiVisibility = originalSystemUiVisibility
            requestedOrientation = originalOrientation
            customViewCallback!!.onCustomViewHidden()
            customViewCallback = null
        }

        override fun onShowCustomView(
            paramView: View,
            paramCustomViewCallback: CustomViewCallback
        ) {
            if (customView != null) {
                onHideCustomView()
                return
            }
            customView = paramView
            originalSystemUiVisibility = window.decorView.systemUiVisibility
            originalOrientation = requestedOrientation
            customViewCallback = paramCustomViewCallback
            (window.decorView as FrameLayout).addView(customView, FrameLayout.LayoutParams(-1, -1))
            window.decorView.systemUiVisibility = 3846 or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        wvHtml!!.saveState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        wvHtml!!.restoreState(savedInstanceState)
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        if (wvHtml!!.canGoBack()) {
            wvHtml!!.goBack()
        } else {
            super.onBackPressed()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        wvHtml!!.stopLoading()
        wvHtml!!.destroy()

    }
}