package net.radityalabs.alquran.di.component

import dagger.Component
import net.radityalabs.alquran.data.di.component.HttpComponent
import net.radityalabs.alquran.data.di.module.HttpModule
import net.radityalabs.alquran.di.component.base.AppComponent
import net.radityalabs.alquran.di.module.AppModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class, HttpModule::class))
interface GenericComponent : AppComponent, HttpComponent