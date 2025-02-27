package part1.aoc_2020_3.b


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

    val count1 = calcTreesInSlope(0,0,1,1,mapData.size-1, travelMap)
    val count2 = calcTreesInSlope(0,0,3,1,mapData.size-1, travelMap)
    val count3 = calcTreesInSlope(0,0,5,1,mapData.size-1, travelMap)
    val count4 = calcTreesInSlope(0,0,7,1,mapData.size-1, travelMap)
    val count5 = calcTreesInSlope(0,0,1,2,mapData.size-1, travelMap)


    val res = (count1*count2*count3*count4*count5) // should be 2832009600

    println(res) // should be 2832009600


}