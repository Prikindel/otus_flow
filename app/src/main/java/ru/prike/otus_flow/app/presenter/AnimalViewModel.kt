package ru.prike.otus_flow.app.presenter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.prike.otus_flow.app.domain.AnimalController
import ru.prike.otus_flow.app.model.AnimalState

class AnimalViewModel(
    private val controller: AnimalController = AnimalController()
): ViewModel() {

    private val _state = MutableLiveData(AnimalState.Default)
    val state: LiveData<AnimalState> get() = _state

    init {
        loadAnimals()
    }

    private fun loadAnimals() {
        viewModelScope.launch {
            showLoading()

            val animals = controller.getAnimals()
            updateState {
                copy(
                    animals = animals
                )
            }

            hideLoading()
        }
    }

    private fun showLoading() {
        updateState {
            copy(isLoading = true)
        }
    }

    private fun hideLoading() {
        updateState {
            copy(isLoading = false)
        }
    }

    private fun updateState(update: AnimalState.() -> AnimalState) {
        _state.value = _state.value?.update()
    }

}