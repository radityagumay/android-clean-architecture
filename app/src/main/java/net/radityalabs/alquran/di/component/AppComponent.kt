package net.radityalabs.alquran.di.component

import android.content.Context
import dagger.Component
import net.radityalabs.alquran.App
import net.radityalabs.alquran.data.di.module.HttpModule
import net.radityalabs.alquran.di.module.AppModule
import net.radityalabs.alquran.domain.repository.SurahRepository
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class, HttpModule::class))
interface AppComponent {
    fun app(): App?

    fun context(): Context
}