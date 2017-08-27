package net.radityalabs.alquran.domain.interactor

import net.radityalabs.alquran.domain.repository.SurahRepository
import javax.inject.Inject

class SurahInteractor @Inject constructor(val repository: SurahRepository) {
    fun getAllSurah() = repository.allSurah()
}