package net.radityalabs.alquran.domain.interactor.impl

import net.radityalabs.alquran.domain.interactor.SurahInteractor
import net.radityalabs.alquran.domain.repository.SurahRepository

class SurahInteractorImpl(val callback: SurahInteractor.Callback,
                          val repository: SurahRepository) : SurahInteractor {

    override fun getAllSurah() {
        /* todo worker thread */
        callback.onAllSurahRetrieved()
    }
}