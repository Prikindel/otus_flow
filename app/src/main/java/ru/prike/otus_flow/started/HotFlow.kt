package ru.prike.otus_flow.started

import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import ru.prike.otus_flow.Animal
import ru.prike.otus_flow.Animal.*
import kotlin.system.measureTimeMillis


/*fun main() {
    flow_channel_flow()
}*/

fun flow_channel_flow() {
    runBlocking {
        val flow = channelFlow {
            Animal.entries.asFlow()
                .collect { animal ->
                    if (animal == Fish)
                        channel.close()
                    else {
                        if (!isClosedForSend) send(animal)
                    }
                }

            awaitClose {
                println("Channel close")
            }
        }

        val time = measureTimeMillis {
            flow.collect { animal ->
                delay(50)
                println("$animal")
            }
        }
        println("$time millis")
    }
}

class FakeAnimalApi {
    interface Callback {
        fun onDataReady(animals: List<Animal>)
    }
    suspend fun getAnimals(callback: Callback) {
        delay(300)
        callback.onDataReady(Animal.entries.toMutableList().apply { remove(Cat) })
        delay(500)
        callback.onDataReady(Animal.entries.toList())
    }
}

/*fun main() {
    flow_callback_flow()
}*/

fun flow_callback_flow() {
    runBlocking {
        val api = FakeAnimalApi()
        val flow = callbackFlow {
            val callback = object : FakeAnimalApi.Callback {
                override fun onDataReady(animals: List<Animal>) {
                    println("ready list  $animals")
                    animals.forEach { animal ->
                        trySend(animal)
                    }
                    if (animals.contains(Cat))
                        channel.close()
                }
            }

            api.getAnimals(callback)

            awaitClose {
                println("Channel Closed")
            }
        }


        flow.collect { animal ->
            println("$animal collected")
        }
    }
}

fun main() {
    sharedFlow()
}

fun sharedFlow() {
    runBlocking {
        val flow = MutableSharedFlow<Animal>(replay = 2)

        val job1 = launch {
            flow.tryEmit(Cat)
            delay(100)
            flow.tryEmit(Dog)
            delay(100)
            flow.tryEmit(Fish)
            delay(100)
            flow.tryEmit(Bird)
            delay(100)
        }

        delay(50)

        val job2 = launch {
            flow.collect { animal ->
                println("job1 -> $animal collected")
            }
        }

        val job3 = launch {
            delay(200)
            flow.collect { animal ->
                println("job3 -> $animal collected")
            }
        }

        delay(1000)
        job1.cancel()
        job2.cancel()
        job3.cancel()
    }
}

/*fun main() {
    stateFlow()
}*/

fun stateFlow() {
    runBlocking {

    }
}