package part1.aoc_2020_3.b


import java.io.File


data class Point(val x: Int, val y: Int)



fun main() {
    val mapData = File("aoc-input/aoc-2020-3a-input.txt").readLines().toList()

    val travelMap: MutableMap<Point, Char> = HashMap()

    val xBound = mapData[0].length
    val yBound = mapData.size-1

    mapData.forEachIndexed { y, line ->
        line.trim().forEachIndexed { x, symbol ->
                travelMap.putIfAbsent(Point(x, y), symbol)
        }
    }

    val count1 = calcTreesInSlope(0,0,1,1,xBound, yBound, travelMap)
    val count2 = calcTreesInSlope(0,0,3,1,xBound, yBound, travelMap)
    val count3 = calcTreesInSlope(0,0,5,1,xBound, yBound, travelMap)
    val count4 = calcTreesInSlope(0,0,7,1,xBound, yBound, travelMap)
    val count5 = calcTreesInSlope(0,0,1,2,xBound, yBound, travelMap)


    val res = (count1*count2*count3*count4*count5) // should be 2832009600

    println(res) // should be 2832009600
}

tailrec fun calcTreesInSlope(x:Int = 0, y:Int = 0,
                             xIncr: Int, yIncr: Int,
                             xBound: Int, yBound: Int,
                             travelMap: Map<Point, Char>,
                             count:Long=0L): Long {

    if (y>yBound) return count

    return when (travelMap[Point(x, y)] == '#') {
        true -> calcTreesInSlope((x+xIncr)%xBound, y+yIncr, xIncr, yIncr, xBound, yBound, travelMap, count+1)
        false -> calcTreesInSlope((x+xIncr)%xBound, y+yIncr, xIncr, yIncr, xBound, yBound, travelMap, count)
    }
}