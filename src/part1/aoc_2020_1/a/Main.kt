package part1.aoc_2020_1.a

import java.io.File
import kotlin.math.abs

fun main() {
    val linesToMapWithSubtract = File("aoc-input/aoc-2020-1a-input.txt").readLines()
        .map { it.toInt() }
        .groupingBy { it-2020 }
        .reduce{ _, num, _ -> num}

    val result = linesToMapWithSubtract.filter{ abs(it.key) in linesToMapWithSubtract.values}
                                         .values.reduce{ a, b -> a * b}


    println(linesToMapWithSubtract)
    println(result) // should be 692916
}