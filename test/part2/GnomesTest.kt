package part2

import org.junit.jupiter.api.Assertions.*

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

 class GnomesTest {

  val hierarchyMapHappyFlow: Map<String, Set<String>> = mapOf(
   "Tomten" to setOf("Glader", "Butter"),
   "Glader" to setOf("Tröger", "Trötter", "Blyger"),
   "Butter" to setOf("Rådjuret", "Nyckelpigan", "Haren", "Räven"),
   "Trötter" to setOf("Skumtomten"),
   "Räven" to setOf("Gråsuggan", "Myran"),
   "Skumtomten" to setOf("Dammråttan"),
   "Myran" to setOf("Bladlusen")
  )

  val hierarchyMapEmpty: Map<String, Set<String>> = mapOf()


@org.junit.jupiter.api.Test
 fun allHierarchiesHappyFlow() {
     assertEquals(setOf("Dammråttan"), findGnomesBelow("Skumtomten", hierarchyMapHappyFlow))
 }
}