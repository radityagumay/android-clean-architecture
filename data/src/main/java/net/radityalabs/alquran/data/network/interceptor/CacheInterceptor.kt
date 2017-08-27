package net.radityalabs.alquran.data.network.interceptor

import android.content.Context
import net.radityalabs.alquran.data.extension.isNetworkConnected
import okhttp3.CacheControl
import okhttp3.Interceptor
import okhttp3.Response

class CacheInterceptor(val context: Context) : Interceptor {
    override fun intercept(chain: Interceptor.Chain?): Response? {
        var request = chain?.request()
        if (!isNetworkConnected(context)) {
            request = request?.newBuilder()
                    ?.cacheControl(CacheControl.FORCE_CACHE)
                    ?.build()
        }
        val response = chain?.proceed(request)
        if (isNetworkConnected(context)) {
            val maxAge = 0
            response?.newBuilder()
                    ?.header("Cache-Control", "public, max-age=" + maxAge)
                    ?.removeHeader("Pragma")
                    ?.build()
        } else {
            val maxStale = 60 * 60 * 24 * 28
            response?.newBuilder()
                    ?.header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                    ?.removeHeader("Pragma")
                    ?.build()
        }
        return response
    }
}
