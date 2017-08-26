package net.radityalabs.alquran.di.component

import dagger.Component
import android.app.Activity
import net.radityalabs.alquran.di.module.FragmentModule
import net.radityalabs.alquran.di.scope.FragmentScope

@FragmentScope
@Component(dependencies = arrayOf(AppComponent::class), modules = arrayOf(FragmentModule::class))
interface FragmentComponent {
    fun activity(): Activity
}
