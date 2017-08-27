package net.radityalabs.alquran.di.module

import android.content.Context
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import net.radityalabs.alquran.data.di.scope.DefaultUrl
import net.radityalabs.alquran.data.network.ApiConstant
import net.radityalabs.alquran.data.network.RestService
import net.radityalabs.alquran.data.network.interceptor.CacheInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class HttpModule {
    @Singleton
    @Provides
    fun provideRetrofitBuilder(): Retrofit.Builder = Retrofit.Builder()

    @Singleton
    @Provides
    fun provideOkHttpBuilder(): OkHttpClient.Builder = OkHttpClient.Builder()

    @Singleton
    @Provides
    @DefaultUrl
    fun provideRetrofit(builder: Retrofit.Builder, client: OkHttpClient): Retrofit {
        return builder.baseUrl(ApiConstant.BASE_URL)
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    @Singleton
    @Provides
    fun provideCacheInterceptor(context: Context): CacheInterceptor = CacheInterceptor(context)

    @Singleton
    @Provides
    fun provideClient(builder: OkHttpClient.Builder, cacheInterceptor: CacheInterceptor): OkHttpClient {
        /*if (BuildConfig.DEBUG) {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            builder.addInterceptor(loggingInterceptor)
        }*/
        builder.addNetworkInterceptor(cacheInterceptor)
        builder.connectTimeout(20, TimeUnit.SECONDS)
        builder.readTimeout(20, TimeUnit.SECONDS)
        builder.writeTimeout(20, TimeUnit.SECONDS)
        builder.retryOnConnectionFailure(true)
        return builder.build()
    }

    @Singleton
    @Provides
    fun provideRestService(@DefaultUrl retrofit: Retrofit): RestService =
            retrofit.create(RestService::class.java)
}
