package com.mf.weatherapp.ui.weather

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.doOnPreDraw
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.google.android.material.transition.MaterialContainerTransform
import com.google.android.material.transition.MaterialFadeThrough
import com.mf.weatherapp.R
import com.mf.weatherapp.databinding.WeatherFragmentBinding
import com.mf.weatherapp.extensions.themeColor
import com.mf.weatherapp.ui.base.BaseFragment

class WeatherFragment : BaseFragment() {

    private val viewModel: WeatherViewModel by viewModels()
    private val args: WeatherFragmentArgs by navArgs()
    private lateinit var binding: WeatherFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enterTransition = MaterialFadeThrough().apply {
            duration = resources.getInteger(R.integer.enter_animation_duration).toLong()
        }
        sharedElementEnterTransition = MaterialContainerTransform().apply {
            drawingViewId = R.id.nav_host_fragment
            duration = resources.getInteger(R.integer.reply_motion_duration).toLong()
            scrimColor = Color.TRANSPARENT
            setAllContainerColors(requireContext().themeColor(R.attr.colorSurface))
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View = WeatherFragmentBinding.inflate(inflater).also {
        it.viewModel = viewModel
        it.lifecycleOwner = viewLifecycleOwner
        it.location = args.location
        it.weatherFragmentRv.adapter = WeatherAdapter(mutableListOf())
        viewModel.getWeatherInfo(args.location)
        binding = it
    }.root

}