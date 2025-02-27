package part1.aoc_2020_2.b

import java.io.File

fun main() {
    val numCorrectPassword = File("aoc-input/aoc-2020-2b-input.txt").readLines().count { passwordIsCorrect(it) }
    println(numCorrectPassword) // should be 352
}

fun passwordIsCorrect(pws: String) : Boolean {
    val index1 = pws.split(" ")[0].split("-")[0].toInt()-1
    val index2 = pws.split(" ")[0].split("-")[1].toInt()-1
    val letter = pws.split(" ")[1].split(":")[0][0]
    val password = pws.split(" ")[2]

    return (password[index1] == letter && password[index2] != letter) ||
           (password[index1] != letter && password[index2] == letter)
}