package net.radityalabs.alquran.di.module

import dagger.Module
import dagger.Provides
import net.radityalabs.alquran.App
import net.radityalabs.alquran.data.network.RestService
import net.radityalabs.alquran.domain.repository.SurahRepository
import net.radityalabs.alquran.domain.repository.impl.SurahRepositoryImpl
import javax.inject.Singleton

@Module
class AppModule(val app: App? = null) {
    @Singleton
    @Provides
    fun provideApp() = app

    @Singleton
    @Provides
    fun provideContext() = app?.applicationContext

    @Singleton
    @Provides
    fun provideSurahRepository(val restService: RestService) : SurahRepository =
            SurahRepositoryImpl(app?.applicationContext!!, restService)
}