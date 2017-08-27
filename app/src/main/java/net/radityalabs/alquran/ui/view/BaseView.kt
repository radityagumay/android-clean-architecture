package net.radityalabs.alquran.ui.view

interface BaseView {

    fun showProgress()

    fun hideProgress()

    fun showError(message: String)
}
