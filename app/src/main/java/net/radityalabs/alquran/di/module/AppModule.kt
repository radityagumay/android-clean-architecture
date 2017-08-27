package net.radityalabs.alquran.di.module

import android.content.Context
import dagger.Module
import dagger.Provides
import net.radityalabs.alquran.App
import javax.inject.Singleton

@Module
class AppModule(val app: App? = null) {
    @Singleton
    @Provides
    fun provideApp(): App? = app

    @Singleton
    @Provides
    fun provideContext(): Context = app?.applicationContext!!
}