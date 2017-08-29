package net.radityalabs.alquran.data.repository

import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import net.radityalabs.alquran.data.network.RestService
import net.radityalabs.alquran.domain.model.Surah
import net.radityalabs.alquran.domain.repository.SurahRepository
import javax.inject.Singleton

class SurahRepositoryImpl(private val restService: RestService) : SurahRepository {
    override fun allSurah(): Single<List<Surah>> {
        return restService.loadSurah()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map { response ->
                    val items = mutableListOf<Surah>()
                    if (response?.data?.size!! > 1) {
                        for (item in 0 until response.data.size) {
                            val surah = response.data[item]
                            items.add(Surah(item, surah.name, surah.englishName, surah.numberOfAyahs, surah.englishNameTranslation, surah.revelationType))
                        }
                    }
                    items
                }
    }
}