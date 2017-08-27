package net.radityalabs.alquran.data.extension

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

fun isWifiConnected(context: Context): Boolean {
    val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val wifi = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).state
    return wifi == NetworkInfo.State.CONNECTED
}

fun isMobileNetworkConnected(context: Context): Boolean {
    val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val mobile = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).state
    return mobile == NetworkInfo.State.CONNECTED
}

fun isNetworkConnected(context: Context): Boolean {
    var netstate = false
    val connectivity = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val info = connectivity.allNetworkInfo
    if (info != null) {
        for (anInfo in info) {
            if (anInfo.state == NetworkInfo.State.CONNECTED) {
                netstate = true
                break
            }
        }
    }
    return netstate
}