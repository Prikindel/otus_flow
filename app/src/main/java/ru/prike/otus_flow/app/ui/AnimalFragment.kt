package ru.prike.otus_flow.app.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import ru.prike.otus_flow.app.model.AnimalState
import ru.prike.otus_flow.app.presenter.AnimalViewModel

class AnimalFragment: Fragment() {

    private val animalViewModel: AnimalViewModel by lazy { ViewModelProvider(this).get(
        AnimalViewModel::class) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        animalViewModel.observeState()
    }

    private fun AnimalViewModel.observeState() {
        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.RESUMED) {
                state.collect { state ->
                    showOrHideLoading(state.isLoading)
                    updateUi(state)
                }
            }
        }
    }

    private fun updateUi(newState: AnimalState) {
        // ...
    }

    private fun showOrHideLoading(isShow: Boolean) {
        // ....
    }

}