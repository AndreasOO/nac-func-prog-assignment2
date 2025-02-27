package part1.aoc_2020_2.a

import java.io.File

fun main() {
    val numCorrectPassword = File("aoc-input/aoc-2020-2a-input.txt").readLines().count { passwordIsCorrect(it) }
    println(numCorrectPassword) // should be 586
}

fun passwordIsCorrect(pws: String) : Boolean {
    val min = pws.split(" ")[0].split("-")[0].toInt()
    val max = pws.split(" ")[0].split("-")[1].toInt()
    val letter = pws.split(" ")[1].split(":")[0]
    val password = pws.split(" ")[2]
    val remaining = password.length - password.replace(letter,"").length
    return remaining in min..max
}