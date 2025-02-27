package part1.aoc_2020_3.a

import java.io.File

data class Point(val x: Int, val y: Int)

tailrec fun calcTreesInSlope(x:Int = 0, y:Int = 0, xIncr: Int, yIncr: Int, yBound: Int, travelMap: Map<Point, Char>, count:Long=0L): Long {
    if (y>yBound) return count

    return when (travelMap[Point(x, y)] == '#') {
        true -> calcTreesInSlope((x+xIncr)%31, y+yIncr, xIncr, yIncr, yBound, travelMap, count+1)
        false -> calcTreesInSlope((x+xIncr)%31, y+yIncr, xIncr, yIncr, yBound, travelMap, count)
    }
}

fun main() {
    val mapData = File("aoc-input/aoc-2020-3a-input.txt").readLines().toList()

    val travelMap: MutableMap<Point, Char> = HashMap()

    mapData.forEachIndexed { y, line ->
        line.trim().forEachIndexed { x, symbol ->
            travelMap.putIfAbsent(Point(x % line.length, y), symbol)
        }
    }

    val result = calcTreesInSlope(0,0,3,1,mapData.size-1, travelMap)
    println(result) // should be 240


}