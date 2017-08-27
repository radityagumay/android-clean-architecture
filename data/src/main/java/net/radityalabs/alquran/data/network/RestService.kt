package net.radityalabs.alquran.data.network

import io.reactivex.Single
import net.radityalabs.alquran.data.network.response.SurahResponse
import retrofit2.http.GET

interface RestService {
    @GET(ApiConstant.SURAH)
    fun loadSurah(): Single<SurahResponse>
}