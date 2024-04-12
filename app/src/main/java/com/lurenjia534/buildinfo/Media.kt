package com.lurenjia534.buildinfo

import android.content.Context
import android.media.MediaCodecList
import android.view.WindowManager
import android.util.DisplayMetrics

class Media(context: Context) {
    private val windowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
    private val display = windowManager.defaultDisplay
    private val displayMetrics = DisplayMetrics().also { display.getRealMetrics(it) }

    val supportedEncoder: String
        get() {
            val codecList = MediaCodecList(MediaCodecList.ALL_CODECS)
            return codecList.codecInfos.filter { it.isEncoder }.joinToString(", ") { it.name }
        }

    val supportedDecoder: String
        get() {
            val codecList = MediaCodecList(MediaCodecList.ALL_CODECS)
            return codecList.codecInfos.filterNot { it.isEncoder }.joinToString(", ") { it.name }
        }

    // HDR capabilities are not directly available in Android system properties
    val hdr10: String = "Not Available"
    val hdr10Plus: String = "Not Available"
    val hlg: String = "Not Available"
    val dolbyVision: String = "Not Available"

    val screenRefreshRate: Float
        get() = display.refreshRate

}