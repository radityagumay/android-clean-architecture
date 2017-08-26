package net.radityalabs.alquran.di.component

import dagger.Component
import net.radityalabs.alquran.App
import net.radityalabs.alquran.di.module.AppModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
    fun context(): App?
}