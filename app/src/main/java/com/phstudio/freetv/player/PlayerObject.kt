package com.phstudio.freetv.player

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.graphics.Point
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.ContextThemeWrapper

object PlayerObject {

    @SuppressLint("DiscouragedApi")
    private fun getNavBarHeight(context: Context): Int {
        if (!hasNavBar(context)) {
            return 0
        }
        val res = context.resources
        val resId = res.getIdentifier(
            "navigation_bar_height",
            "dimen", "android"
        )
        return res.getDimensionPixelSize(resId)
    }

    private fun hasNavBar(context: Context): Boolean {
        val display = getWindowManager(context).defaultDisplay
        val size = Point()
        val realSize = Point()
        display.getSize(size)
        display.getRealSize(realSize)
        return realSize.x != size.x || realSize.y != size.y
    }

    fun getScreenWidth(context: Context, isNav: Boolean): Int {
        return if (isNav) {
            context.resources.displayMetrics.widthPixels + getNavBarHeight(context)
        } else {
            context.resources.displayMetrics.widthPixels
        }
    }

    fun getScreenHeight(context: Context, isIncludeNav: Boolean): Int {
        return if (isIncludeNav) {
            context.resources.displayMetrics.heightPixels + getNavBarHeight(context)
        } else {
            context.resources.displayMetrics.heightPixels
        }
    }

    @SuppressLint("RestrictedApi")
    fun hideActionBar(context: Context?) {
        val appCompatActivity = getAppCompatActivity(context)
        if (appCompatActivity != null) {
            val ab = appCompatActivity.supportActionBar
            if (ab != null && ab.isShowing) {
                ab.setShowHideAnimationEnabled(false)
                ab.hide()
            }
        }
    }

    @SuppressLint("RestrictedApi")
    fun showActionBar(context: Context?) {
        val appCompatActivity = getAppCompatActivity(context)
        if (appCompatActivity != null) {
            val ab = appCompatActivity.supportActionBar
            if (ab != null && !ab.isShowing) {
                ab.setShowHideAnimationEnabled(false)
                ab.show()
            }
        }
    }

    fun scanForActivity(context: Context?): Activity? {
        return when (context) {
            null -> null
            is Activity -> context
            is ContextWrapper -> scanForActivity(
                context.baseContext
            )
            else -> null
        }
    }

    private fun getAppCompatActivity(context: Context?): AppCompatActivity? {
        if (context == null) return null
        if (context is AppCompatActivity) {
            return context
        } else if (context is ContextThemeWrapper) {
            return getAppCompatActivity(context.baseContext)
        }
        return null
    }

    private fun getWindowManager(context: Context): WindowManager {
        return context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
    }
}