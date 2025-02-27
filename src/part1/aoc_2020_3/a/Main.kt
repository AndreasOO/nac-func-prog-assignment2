package part1.aoc_2020_3.a

import java.io.File

data class Point(val x: Int, val y: Int)

fun calcTreesInSlope(xIncr: Int, yIncr: Int, yBound: Int, travelMap: Map<Point, String>): Int {
    var x = 0
    var y = 0
    var count = 0
    while (y <= yBound) {
        y+=yIncr
        x += xIncr
        x %= 31
        if (travelMap[Point(x, y)].equals("#")) {
            count++
        }
    }
    println(count)
    return count
}

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

    val res = calcTreesInSlope(3,1,mapData.size-1, travelMap).toLong()

    println(res) // should be 240


}