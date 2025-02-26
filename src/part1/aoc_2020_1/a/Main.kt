package part1.aoc_2020_1.a

import java.io.File
import kotlin.math.abs

fun main() {
    val linesToIntMapWithRemainderAsKey = File("aoc-input/aoc-2020-1-input.txt").readLines()
        .map { it.toInt() }
        .filter { it <= 2020 }
        .groupingBy { abs(it-2020) }
        .reduce{ _, num, _ -> num}

    val result = linesToIntMapWithRemainderAsKey.filter{ it.key in linesToIntMapWithRemainderAsKey.values}
        .values.reduce{ a, b -> a * b}


    println(linesToIntMapWithRemainderAsKey)
    println(result) // should be 692916
}