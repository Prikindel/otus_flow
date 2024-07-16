@file:OptIn(ExperimentalCoroutinesApi::class)

package ru.prike.otus_flow.started

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.Channel.Factory.BUFFERED
import kotlinx.coroutines.channels.Channel.Factory.CONFLATED
import kotlinx.coroutines.channels.Channel.Factory.RENDEZVOUS
import kotlinx.coroutines.channels.Channel.Factory.UNLIMITED
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import ru.prike.otus_flow.Animal
import ru.prike.otus_flow.Animal.*

/*fun main() {
    channel_basic()
}*/

fun channel_basic() {
    runBlocking {
        val channel = Channel<Animal>()
        launch {
            channel.send(Cat)
        }
        launch {
            val animal = channel.receive()
            println(animal)
        }
    }
}

/*fun main() {
    channel_consumeEach()
}*/

fun channel_consumeEach() {
    runBlocking {
        val channel = Channel<Animal>()
        launch {
            channel.send(Cat)
            channel.send(Dog)
            channel.send(Fish)
            channel.close()
        }
        launch {
            channel.consumeEach { animal ->
                println(animal)
            }
        }
    }
}

/*fun main() {
    channel_produce()
}*/

fun channel_produce() {
    runBlocking {
        val channel = produce {
            send(Cat)
            send(Dog)
            send(Fish)
        }
        launch {
            channel.consumeEach { animal ->
                println(animal)
            }
        }
    }
}

/*fun main() {
    channel_produce_with_capacity()
}*/

fun channel_produce_with_capacity() {
    runBlocking {
        val channel = produce(capacity = 2) {
            send(Cat)
            send(Dog)
            send(Fish)
        }
        launch {
            channel.consumeEach { animal ->
                delay(100)
                println(animal)
            }
        }
    }
}

fun main() {
    channel_produce_conflate()
}

fun channel_produce_conflate() {
    runBlocking {
        val channel = produce(capacity = CONFLATED) {
            send(Cat)
            println("send Cat")
            send(Dog)
            println("send Dog")
            send(Fish)
            println("send Fish")
        }
        launch {
            delay(100)
            println("${channel.receive()} received")
        }
    }
}

/*fun main() {
    channel_produce_rendezvous()
}*/

fun channel_produce_rendezvous() {
    runBlocking {

    }
}

/*fun main() {
    channel_produce_unlimited()
}*/

fun channel_produce_unlimited() {
    runBlocking {

    }
}