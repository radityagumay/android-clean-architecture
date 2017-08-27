package net.radityalabs.alquran.domain.repository

import io.reactivex.Single
import net.radityalabs.alquran.domain.model.Surah

interface SurahRepository {
    fun allSurah(): Single<List<Surah>>
}