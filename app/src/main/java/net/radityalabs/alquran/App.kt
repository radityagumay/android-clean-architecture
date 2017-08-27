package net.radityalabs.alquran

import android.app.Application
import net.radityalabs.alquran.di.module.HttpModule
import net.radityalabs.alquran.di.component.AppComponent
import net.radityalabs.alquran.di.component.DaggerAppComponent
import net.radityalabs.alquran.di.module.AppModule

class App : Application() {
    companion object {
        var sInstance: App? = null
            private set
        var sAppComponent: AppComponent? = null
            private set
    }

    override fun onCreate() {
        super.onCreate()
        sInstance = this
        getAppComponent()
    }

    private fun getAppComponent(): AppComponent? {
        if (sAppComponent == null) {
            sAppComponent = DaggerAppComponent.builder()
                    .appModule(AppModule(sInstance))
                    .httpModule(HttpModule())
                    .build()
        }
        return sAppComponent
    }
}