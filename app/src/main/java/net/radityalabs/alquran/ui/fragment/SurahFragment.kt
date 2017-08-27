package net.radityalabs.alquran.ui.fragment

import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_surah.*
import net.radityalabs.alquran.R
import net.radityalabs.alquran.di.module.SurahModule
import net.radityalabs.alquran.presenter.SurahPresenter
import net.radityalabs.alquran.ui.adapter.SurahAdapter
import net.radityalabs.alquran.ui.model.SurahData

class SurahFragment : BaseFragment<SurahPresenter.View, SurahPresenter>(), SurahPresenter.View {
    companion object {
        val TAG = SurahFragment::class.java.simpleName

        fun newInstance() = SurahFragment()
    }

    private lateinit var surahAdapter: SurahAdapter

    override fun setupInjection() {
        fragmentComponent.plus(SurahModule()).inject(this)
    }

    override fun setupEvent() {
        surahAdapter = SurahAdapter()
    }

    override fun getLayoutId() = R.layout.fragment_surah

    override fun setupView() {
        surah.adapter = surahAdapter
        surah.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }

    override fun setupData() {
        presenter.getAllSurah()
    }

    override fun showError(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    override fun showProgress() {

    }

    override fun hideProgress() {
    }

    override fun showListSurah(items: List<SurahData>) {
        surahAdapter.setNotifyDataChanges(items)
    }
}