package net.radityalabs.alquran.di.module

import android.app.Activity
import android.support.v4.app.Fragment
import dagger.Module
import dagger.Provides
import net.radityalabs.alquran.di.scope.FragmentScope

@Module
class FragmentModule(private val fragment: Fragment) {
    @Provides
    @FragmentScope
    fun provideActivity(): Activity = fragment.activity
}
