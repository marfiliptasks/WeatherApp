package com.mf.weatherapp.ui.base

data class BaseState(val isLoadingData:Boolean = false, val error: Throwable? = null)