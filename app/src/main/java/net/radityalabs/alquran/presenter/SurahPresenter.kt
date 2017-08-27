package net.radityalabs.alquran.presenter

import android.util.Log
import net.radityalabs.alquran.di.scope.PerActivity
import net.radityalabs.alquran.domain.interactor.SurahInteractor
import net.radityalabs.alquran.ui.model.SurahData
import net.radityalabs.alquran.ui.presenter.BasePresenter
import net.radityalabs.alquran.ui.view.BaseView
import javax.inject.Inject

class SurahPresenter @Inject constructor(private val interactor: SurahInteractor) :
        BasePresenter<SurahPresenter.View>() {

    companion object {
        val TAG = SurahPresenter::class.java.simpleName
    }

    fun getAllSurah() {
        interactor.getAllSurah().subscribe({
            success ->
            Log.d(TAG, success.toString())
            //view.showListSurah(success)
        }, {
            error ->
            Log.e(TAG, "error gan")
            view.showError(if (error.message.isNullOrEmpty()) "Something Error" else error.message!!)
        })
    }

    interface View : BaseView {
        fun showListSurah(items: List<SurahData>)
    }
}
