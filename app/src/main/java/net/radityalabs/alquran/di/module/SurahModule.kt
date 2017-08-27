package net.radityalabs.alquran.di.module

import dagger.Module
import dagger.Provides
import net.radityalabs.alquran.data.network.RestService
import net.radityalabs.alquran.data.repository.SurahRepositoryImpl
import net.radityalabs.alquran.domain.repository.SurahRepository
import javax.inject.Singleton

@Module
class SurahModule {
    @Singleton
    @Provides
    fun provideSurahRepository(restService: RestService): SurahRepository =
            SurahRepositoryImpl(restService)
}