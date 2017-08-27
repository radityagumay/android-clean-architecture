package net.radityalabs.alquran

import android.app.Application
import net.radityalabs.alquran.data.di.module.HttpModule
import net.radityalabs.alquran.di.component.DaggerGenericComponent
import net.radityalabs.alquran.di.component.GenericComponent
import net.radityalabs.alquran.di.module.AppModule

class App : Application() {
    companion object {
        var sInstance: App? = null
            private set

        var sGenericComponent: GenericComponent? = null
            private set
    }

    override fun onCreate() {
        super.onCreate()
        sInstance = this

        setupGenericComponent()
    }

    private fun setupGenericComponent() {
        if (sGenericComponent == null) {
            sGenericComponent = DaggerGenericComponent.builder()
                    .httpModule(HttpModule())
                    .appModule(AppModule(sInstance))
                    .build()
        }
    }
}