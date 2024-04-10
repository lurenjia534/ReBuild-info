package com.lurenjia534.buildinfo

import android.os.Build

class DeviceInfo {
    val androidVersion:String = Build.VERSION.RELEASE
    val androidLevel:String = Build.VERSION.SDK_INT.toString()
    val androidBuildID:String = Build.ID
    val brand:String = Build.BRAND
    val manufacturer:String = Build.MANUFACTURER
    val model:String = Build.MODEL
    val board:String = Build.BOARD
    val buildFingerprint:String = Build.FINGERPRINT
    val product:String = Build.PRODUCT
    val sku:String = Build.SKU
    val buildType:String = Build.TYPE
}