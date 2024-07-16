package ru.prike.otus_flow.started

import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import ru.prike.otus_flow.Animal
import kotlin.system.measureTimeMillis


/*fun main() {
    flow_channel_flow()
}*/

fun flow_channel_flow() {
    runBlocking {

    }
}

class FakeAnimalApi {
    interface Callback {
        fun onDataReady(animals: List<Animal>)
    }
    suspend fun getAnimals(callback: Callback) {
        delay(300)
        callback.onDataReady(Animal.entries.toMutableList().apply { remove(Animal.Cat) })
        delay(500)
        callback.onDataReady(Animal.entries.toList())
    }
}

/*fun main() {
    flow_callback_flow()
}*/

fun flow_callback_flow() {
    runBlocking {

    }
}

/*fun main() {
    sharedFlow()
}*/

fun sharedFlow() {
    runBlocking {

    }
}

/*fun main() {
    stateFlow()
}*/

fun stateFlow() {
    runBlocking {

    }
}