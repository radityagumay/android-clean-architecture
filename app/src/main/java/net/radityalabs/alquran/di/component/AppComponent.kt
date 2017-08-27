package net.radityalabs.alquran.di.component

import android.content.Context
import dagger.Component
import net.radityalabs.alquran.App
import net.radityalabs.alquran.di.module.HttpModule
import net.radityalabs.alquran.data.network.RestService
import net.radityalabs.alquran.data.network.RetrofitHelper
import net.radityalabs.alquran.di.module.AppModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class, HttpModule::class))
interface AppComponent {
    fun appContext(): App?

    fun context(): Context

    fun retrofitHelper(): RetrofitHelper

    fun restService(): RestService
}