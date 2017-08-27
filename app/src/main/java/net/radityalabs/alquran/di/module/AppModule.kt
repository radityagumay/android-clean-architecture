package net.radityalabs.alquran.di.module

import dagger.Module
import dagger.Provides
import net.radityalabs.alquran.App
import javax.inject.Singleton

@Module
class AppModule(val app: App? = null) {
    @Singleton
    @Provides
    fun provideApp() = app

    @Singleton
    @Provides
    fun provideContext() = app?.applicationContext
}