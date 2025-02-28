package part2

/**
 *
Tomten
│
├── Glader
│   ├── Tröger
│   ├── Trötter
│   │   └── Skumtomten
│   │       └── Dammråttan
│   └── Blyger
│
└── Butter
    ├── Rådjuret
    ├── Nyckelpigan
    ├── Haren
    └── Räven
        ├── Gråsuggan
        └── Myran
            └── Bladlusen

*/

fun main() {
    val hierarchyMap: Map<String, Set<String>> = mapOf(
        "Tomten" to setOf("Glader", "Butter"),
        "Glader" to setOf("Tröger", "Trötter", "Blyger"),
        "Butter" to setOf("Rådjuret", "Nyckelpigan", "Haren", "Räven"),
        "Trötter" to setOf("Skumtomten"),
        "Räven" to setOf("Gråsuggan", "Myran"),
        "Skumtomten" to setOf("Dammråttan"),
        "Myran" to setOf("Bladlusen")
    )

    val result = findGnomesBelow("Tomten", hierarchyMap)

    println(result)
}

tailrec fun findGnomesBelow(name:String,
                            hierarchyMap: Map<String, Set<String>>,
                            prevResultSet: Set<String> = hierarchyMap[name].orEmpty()
                            ): Set<String>
{
    val currentResult = prevResultSet.mapNotNull{hierarchyMap[it]}.flatten().union(prevResultSet)

    return when (currentResult.size == prevResultSet.size) {
        true -> currentResult
        false -> findGnomesBelow(name, hierarchyMap, currentResult)
    }
}


