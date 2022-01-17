package com.mf.weatherapp.ui.location

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.doOnPreDraw
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.FragmentNavigatorExtras
import com.mf.weatherapp.R
import com.mf.weatherapp.databinding.LocationFragmentBinding
import com.mf.weatherapp.model.location.LocationModel
import com.mf.weatherapp.ui.base.ItemClickListener
import com.mf.weatherapp.extensions.afterTextChanged
import com.mf.weatherapp.ui.base.BaseFragment
import com.mf.weatherapp.ui.location.adapter.LocationAdapter
import com.mf.weatherapp.ui.location.adapter.QueryStringsAdapter

class LocationFragment : BaseFragment(), ItemClickListener<LocationModel> {

    private lateinit var binding: LocationFragmentBinding
    private val viewModel: LocationViewModel by viewModels()
    private val adapter by lazy { LocationAdapter(this) }
    private val queryAdapter: QueryStringsAdapter by lazy {
        QueryStringsAdapter(requireContext(), R.layout.query_item, arrayListOf())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View = LocationFragmentBinding.inflate(inflater).also {
        it.locationFragmentRv.adapter = adapter
        it.lifecycleOwner = viewLifecycleOwner
        it.viewModel = viewModel
        it.mainFragmentEditText.setAdapter(queryAdapter)
        it.fragment = this
        binding = it
        setupListeners()
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        postponeEnterTransition()
        view.doOnPreDraw { startPostponedEnterTransition() }
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun setupListeners() {
        binding.mainFragmentEditText.afterTextChanged { result ->
            result.fold(
                { text ->
                    viewModel.textChangedSubject.onNext(text)
                    binding.mainFragmentTextLayout.error = null
                }, {
                    binding.mainFragmentTextLayout.error = getString(R.string.wrong_city_name)
                })
        }

        binding.mainFragmentEditText.setOnItemClickListener { _, _, i, _ ->
            queryAdapter.getItem(i)?.let {
                onQuerySelected(it)
            }
        }
    }

    override fun onItemClicked(item: LocationModel, view: View) {
        val weatherFragmentTransitionName = getString(R.string.weather_card_transition_name)
        val extras = FragmentNavigatorExtras(view to weatherFragmentTransitionName)
        navController.navigate(
            LocationFragmentDirections.actionMainFragmentToWeatherFragment(item), extras
        )
    }

    private fun onQuerySelected(item: String) {
        binding.mainFragmentEditText.setText(item)
        viewModel.textChangedSubject.onNext(item)
    }

}