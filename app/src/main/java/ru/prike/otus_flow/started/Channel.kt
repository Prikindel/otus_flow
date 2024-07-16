@file:OptIn(ExperimentalCoroutinesApi::class)

package ru.prike.otus_flow.started

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.Channel
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
}

/*fun main() {
    channel_consumeEach()
}*/

fun channel_consumeEach() {
    runBlocking {

    }
}

/*fun main() {
    channel_produce()
}*/

fun channel_produce() {
    runBlocking {

    }
}

/*fun main() {
    channel_produce_with_capacity()
}*/

fun channel_produce_with_capacity() {
    runBlocking {

    }
}

/*fun main() {
    channel_produce_conflate()
}*/

fun channel_produce_conflate() {
    runBlocking {

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