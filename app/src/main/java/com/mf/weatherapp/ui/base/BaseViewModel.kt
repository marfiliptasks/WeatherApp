package com.mf.weatherapp.ui.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.addTo

abstract class BaseViewModel<ExpectedType : Any, MapperType : Any> : ViewModel() {

    protected val disposables by lazy { CompositeDisposable() }

    private val mutableState = MutableLiveData<BaseState>()
    val state: LiveData<BaseState> = mutableState

    private val mutableItems = MutableLiveData<ExpectedType>()
    val items: LiveData<ExpectedType> = mutableItems


    protected inline fun Single<MapperType>.runWithBaseSideEffects(
        crossinline mapperFunction: (MapperType) -> ExpectedType
    ) = doOnSubscribe(::onStartLoadingData)
            .map { mapperFunction(it) }
            .doAfterSuccess(::afterSuccess)
            .subscribe(::onSuccess, ::onError)
            .addTo(disposables)

    open fun onError(throwable: Throwable) =
        mutableState.postValue(BaseState(error = throwable))

    open fun onSuccess(results: ExpectedType) =
        mutableItems.postValue(results)


    open fun afterSuccess(results: ExpectedType) =
        mutableState.postValue(BaseState())

    open fun onStartLoadingData(disposable: Disposable) =
        mutableState.postValue(BaseState(true))


    override fun onCleared() {
        disposables.dispose()
        super.onCleared()
    }

}