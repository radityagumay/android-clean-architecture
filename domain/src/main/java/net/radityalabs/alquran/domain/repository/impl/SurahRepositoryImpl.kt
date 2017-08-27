package net.radityalabs.alquran.domain.repository.impl

import android.content.Context
import io.reactivex.Single
import net.radityalabs.alquran.domain.model.Surah
import net.radityalabs.alquran.domain.repository.SurahRepository
import javax.inject.Singleton

@Singleton
class SurahRepositoryImpl(val context: Context) : SurahRepository {
    override fun getAllSurah(): Single<List<Surah>> {
        return Single.create {  }
    }
}