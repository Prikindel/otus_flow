package ru.prike.otus_flow.app.domain

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import ru.prike.otus_flow.Animal

class AnimalController {
    suspend fun getAnimals() = withContext(Dispatchers.IO) {
        delay(1000)
        Animal.entries.toList()
    }
}