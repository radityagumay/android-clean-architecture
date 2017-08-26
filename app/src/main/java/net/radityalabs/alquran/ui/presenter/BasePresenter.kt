package net.radityalabs.alquran.ui.presenter

import io.reactivex.SingleTransformer
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import net.radityalabs.alquran.ui.view.BaseView

open class BasePresenter<V : BaseView> {
    lateinit protected var view: V

    private var mCompositeSubscription: CompositeDisposable? = null

    private fun dispose() {
        if (mCompositeSubscription != null) {
            mCompositeSubscription!!.clear()
        }
    }

    protected fun addDisposable(subscription: Disposable) {
        if (mCompositeSubscription == null) {
            mCompositeSubscription = CompositeDisposable()
        }
        mCompositeSubscription!!.add(subscription)
    }

    open fun attachView(view: V) {
        this.view = view
    }

    open fun detachView() {
        dispose()
    }

    fun bindLifeCycle(lifeCycle: SingleTransformer<*, *>) {
        //this.transformations.lifecycle = lifeCycle
    }
}
