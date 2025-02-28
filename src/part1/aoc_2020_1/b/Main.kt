package part1.aoc_2020_1.b

import java.io.File



fun main() {

    val list = File("aoc-input/aoc-2020-1-input.txt").readLines()
        .map { it.toInt() }
        .filter { it <= 2020 }
        .toList()


    val result = calculateProduct(0,0, list)

    println(result) // should be 289270976
}

tailrec fun calculateProduct(index1: Int, index2: Int, list: List<Int>, targetTotalSum:Int = 2020) : Int {

    if (index1 >= list.size) return 0

    val remainder = targetTotalSum - (list[index1] + list[index2])

    if (list.contains(remainder))
        return list[index1] * list[index2] * remainder

    if (index2 < list.size-1)
        return calculateProduct(index1, index2+1, list, targetTotalSum)
    else
        return calculateProduct(index1+1, 0, list, targetTotalSum)
}