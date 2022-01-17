package com.mf.weatherapp.ui.location

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mf.domain.usecases.searchLocation.ILocationUseCase
import com.mf.weatherapp.mappers.toModel
import com.mf.weatherapp.model.aliases.DomainLocationList
import com.mf.weatherapp.model.location.LocationModel
import com.mf.weatherapp.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import java.io.IOException
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@HiltViewModel
class LocationViewModel @Inject constructor(
    private val locationUseCase: ILocationUseCase,
) : BaseViewModel<List<LocationModel>, DomainLocationList>() {

    private val _queries = MutableLiveData<List<String>>()
    val queries: LiveData<List<String>> = _queries

    private companion object {
        const val DEBOUNCE_TIME = 500L
    }

    val textChangedSubject = PublishSubject.create<String>()

    init {
        textChangedSubject
            .distinctUntilChanged()
            .debounce(DEBOUNCE_TIME, TimeUnit.MILLISECONDS)
            .subscribeOn(Schedulers.io())
            .subscribe(::searchLocation, ::onError)
            .addTo(disposables)

        locationUseCase
            .observeQueries()
            .subscribe(_queries::postValue, ::onError)
            .addTo(disposables)

        searchLocation()
    }

    private fun searchLocation(query: String = "") =
        locationUseCase
            .searchForLocation(query)
            .runWithBaseSideEffects(DomainLocationList::toModel)

}

