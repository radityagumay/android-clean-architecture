package net.radityalabs.alquran.di.component

import dagger.Component
import android.app.Activity
import android.content.Context
import net.radityalabs.alquran.di.module.FragmentModule
import net.radityalabs.alquran.di.module.SurahModule
import net.radityalabs.alquran.di.scope.FragmentScope

@FragmentScope
@Component(dependencies = arrayOf(AppComponent::class), modules = arrayOf(FragmentModule::class))
interface FragmentComponent {
    fun activity(): Activity

    fun context(): Context

    fun plus(module: SurahModule): SurahComponent
}
