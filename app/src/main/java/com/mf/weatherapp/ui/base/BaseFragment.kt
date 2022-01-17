package com.mf.weatherapp.ui.base

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
abstract class BaseFragment: Fragment() {
    protected val navController by lazy {
        findNavController()
    }

}