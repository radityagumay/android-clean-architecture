package net.radityalabs.alquran

import android.app.Application
import net.radityalabs.alquran.di.component.AppComponent
import net.radityalabs.alquran.di.component.DaggerAppComponent
import net.radityalabs.alquran.di.module.AppModule

class App : Application() {
    companion object {
        lateinit var instance: App

        var sAppComponent: AppComponent? = null
            private set

        fun getAppComponent(): AppComponent? {
            if (sAppComponent == null) {
                sAppComponent = DaggerAppComponent.builder()
                        .appModule(AppModule(instance))
                        .build()
            }
            return sAppComponent
        }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}