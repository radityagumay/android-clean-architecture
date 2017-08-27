package net.radityalabs.alquran.presenter

import net.radityalabs.alquran.di.scope.PerActivity
import net.radityalabs.alquran.domain.interactor.SurahInteractor
import net.radityalabs.alquran.ui.model.SurahData
import net.radityalabs.alquran.ui.presenter.BasePresenter
import net.radityalabs.alquran.ui.view.BaseView
import javax.inject.Inject

@PerActivity
class SurahPresenter @Inject constructor(private val interactor: SurahInteractor) :
        BasePresenter<SurahPresenter.View>() {

    fun getAllSurah() {
        interactor.getAllSurah().subscribe({
            success ->
            //view.showListSurah(success)
        }, {
            error ->
            view.showError(if (error.message.isNullOrEmpty()) "Something Error" else error.message!!)
        })
    }

    interface View : BaseView {
        fun showListSurah(items: List<SurahData>)
    }
}
