package com.lurenjia534.buildinfo

import android.content.Context
import android.media.MediaCodecList
import android.os.Build
import android.view.WindowManager
import android.util.DisplayMetrics
import android.view.Display
import androidx.annotation.RequiresApi

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

    val hdr10: String
        @RequiresApi(Build.VERSION_CODES.UPSIDE_DOWN_CAKE)
        get() {
            val hdrTypes = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                display.mode?.supportedHdrTypes
            } else {
                null
            }
            return if (hdrTypes != null && Display.HdrCapabilities.HDR_TYPE_HDR10 in hdrTypes) "Supported" else "Not Supported"
        }

    val hlg: String
        @RequiresApi(Build.VERSION_CODES.UPSIDE_DOWN_CAKE)
        get() {
            val hdrTypes = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                display.mode?.supportedHdrTypes
            } else {
                null
            }
            return if (hdrTypes != null && Display.HdrCapabilities.HDR_TYPE_HLG in hdrTypes) "Supported" else "Not Supported"
        }

    val dolbyVision: String
        @RequiresApi(Build.VERSION_CODES.UPSIDE_DOWN_CAKE)
        get() {
            val hdrTypes = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                display.mode?.supportedHdrTypes
            } else {
                null
            }
            return if (hdrTypes != null && Display.HdrCapabilities.HDR_TYPE_DOLBY_VISION in hdrTypes) "Supported" else "Not Supported"
        }

}