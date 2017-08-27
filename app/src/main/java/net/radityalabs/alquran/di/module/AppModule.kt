package net.radityalabs.alquran.di.module

import android.content.Context
import dagger.Module
import dagger.Provides
import net.radityalabs.alquran.App
import net.radityalabs.alquran.data.network.RestService
import net.radityalabs.alquran.data.network.RetrofitHelper
import javax.inject.Singleton

@Module
class AppModule(val app: App? = null) {
    @Singleton
    @Provides
    fun provideApp() = app

    @Singleton
    @Provides
    fun provideContext() : Context = app?.applicationContext!!

    @Singleton
    @Provides
    fun provideRetrofitHelper(service: RestService) = RetrofitHelper(service)
}