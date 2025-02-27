package part1.aoc_2020_3.a

import java.io.File

data class Point(val x: Int, val y: Int)

fun main() {
    val mapData = File("aoc-input/aoc-2020-3a-input.txt").readLines().toList()

    val travelMap : MutableMap<Point, String> = HashMap()

    var y = 0;
    var x = 0;
    for (line in mapData ) {
        for (symbol in line.trim().split("")) {
            if (symbol.isEmpty()) continue
            travelMap.putIfAbsent(Point(x, y), symbol)
            x++
        }
        y++
        x = 0
    }

    x = 0
    y = 0
    var count = 0
    while (y <= mapData.size-1) {
        y++
        x += 3
        x %= 31
        println("$x : $y  ${travelMap[Point(x, y)]}")
        if (travelMap[Point(x, y)].equals("#")) {
            count++
        }
    }

    println(count) // should be 240


}