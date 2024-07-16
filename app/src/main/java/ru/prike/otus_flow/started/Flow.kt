package ru.prike.otus_flow.started

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.filterNot
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flatMapMerge
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.merge
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.zip
import kotlinx.coroutines.runBlocking
import ru.prike.otus_flow.Animal
import kotlin.system.measureTimeMillis

/*fun main() {
    flow_builders()
}*/

fun flow_builders() {

}

/*fun main() {
    flow_basic_intermediate_operators()
}*/

fun flow_basic_intermediate_operators() {
    runBlocking {

    }
}

private fun flowOfNumbers(n: Int, delay: Long = 0L, withLog: Boolean = false) = flow {
    for (i in 1..n) {
        delay(delay)
        if (withLog) println("  Before emit $i")
        emit(i)
        if (withLog) println("  After emit $i")
    }
}

private fun flowOfAnimals(delay: Long = 0L, withLog: Boolean = false) = flow {
    delay(delay)
    if (withLog) println("  Before emit Cat")
    emit(Animal.Cat)
    if (withLog) println("  After emit Cat")
    delay(delay)
    if (withLog) println("  Before emit Dog")
    emit(Animal.Dog)
    if (withLog) println("  After emit Dog")
    delay(delay)
    if (withLog) println("  Before emit Fish")
    emit(Animal.Fish)
    if (withLog) println("  After emit Fish")
    delay(delay)
    if (withLog) println("  Before emit Bird")
    emit(Animal.Bird)
    if (withLog) println("  After emit Bird")
}

/*fun main() {
    flow_flatMap()
}*/

fun flow_flatMap() {
    runBlocking {

    }
}

/*fun main() {
    flow_customOperator()
}*/

fun flow_customOperator() {
    runBlocking {

    }
}

fun <T> Flow<T>.distinctUntilTime(time: Long): Flow<T> {
    return flow {
        var lastTime = System.currentTimeMillis()
        var lastValue: T? = null
        collect { value ->
            if (value != lastValue || (System.currentTimeMillis() - lastTime) >= time) {
                emit(value)
            }
            lastValue = value
            lastTime = System.currentTimeMillis()
        }
    }
}

/*fun main() {
    flow_combining()
}*/

fun flow_combining() {
    runBlocking {

    }
}

/*fun main() {
    flow_with_buffer()
}*/

fun flow_with_buffer() {
    runBlocking {

    }
}