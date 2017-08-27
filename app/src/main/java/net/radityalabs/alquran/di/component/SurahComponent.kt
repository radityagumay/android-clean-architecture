package net.radityalabs.alquran.di.component

import dagger.Subcomponent
import net.radityalabs.alquran.di.module.SurahModule
import net.radityalabs.alquran.ui.fragment.SurahFragment
import javax.inject.Singleton

@Singleton
@Subcomponent(modules = arrayOf(SurahModule::class))
interface SurahComponent {
    fun inject(fragment: SurahFragment)
}