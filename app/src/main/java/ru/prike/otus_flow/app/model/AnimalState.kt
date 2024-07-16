package ru.prike.otus_flow.app.model

import ru.prike.otus_flow.Animal

data class AnimalState(
    val animals: List<Animal>,
    val isLoading: Boolean
) {
    companion object {
        val Default = AnimalState(
            animals = emptyList(),
            isLoading = false
        )
    }
}