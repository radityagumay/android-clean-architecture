package net.radityalabs.alquran.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.trello.rxlifecycle2.android.RxLifecycleAndroid
import net.radityalabs.alquran.App
import net.radityalabs.alquran.di.component.base.DaggerFragmentComponent
import net.radityalabs.alquran.di.component.base.FragmentComponent
import net.radityalabs.alquran.di.module.FragmentModule
import net.radityalabs.alquran.ui.presenter.BasePresenter
import net.radityalabs.alquran.ui.view.BaseView
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
abstract class BaseFragment<V : BaseView, P : BasePresenter<V>> : RxFragment(), BaseView {

    @Inject
    lateinit var presenter: P

    protected val fragmentComponent: FragmentComponent
        get() = DaggerFragmentComponent.builder()
                .genericComponent(App.sGenericComponent)
                .fragmentModule(FragmentModule(this))
                .build()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupInjection()
        setupEvent()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?) =
            inflater?.inflate(getLayoutId(), container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        presenter.bindLifeCycle(RxLifecycleAndroid.bindFragment<Any>(lifecycle()))
        setupView()
        presenter.attachView(this as V)
        setupData()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.detachView()
    }

    protected abstract fun setupInjection()

    protected abstract fun setupEvent()

    protected abstract fun getLayoutId(): Int

    protected abstract fun setupView()

    protected abstract fun setupData()
}
