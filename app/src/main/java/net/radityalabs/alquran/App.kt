package net.radityalabs.alquran

import android.app.Application
import net.radityalabs.alquran.data.di.module.HttpModule
import net.radityalabs.alquran.di.component.base.BaseComponent
import net.radityalabs.alquran.di.component.base.DaggerBaseComponent
import net.radityalabs.alquran.di.module.AppModule

class App : Application() {
    companion object {
        var sInstance: App? = null
            private set

        var sBaseComponent: BaseComponent? = null
            private set
    }

    override fun onCreate() {
        super.onCreate()
        sInstance = this

        setupGenericComponent()
    }

    private fun setupGenericComponent() {
        if (sBaseComponent == null) {
            sBaseComponent = DaggerBaseComponent.builder()
                    .httpModule(HttpModule())
                    .appModule(AppModule(sInstance))
                    .build()
        }
    }
}