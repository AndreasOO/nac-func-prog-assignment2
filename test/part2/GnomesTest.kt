package part2

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;

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


@Test
 fun allHierarchiesHappyFlow() {
 assertEquals(setOf("Glader", "Butter", "Tröger", "Trötter", "Blyger", "Rådjuret", "Nyckelpigan", "Haren",
                    "Räven", "Skumtomten", "Gråsuggan", "Myran", "Dammråttan", "Bladlusen"),
              findGnomesBelow("Tomten", hierarchyMapHappyFlow))

 assertEquals(setOf("Tröger", "Trötter", "Skumtomten", "Dammråttan", "Blyger"), findGnomesBelow("Glader", hierarchyMapHappyFlow))

 assertEquals(setOf<String>(), findGnomesBelow("Tröger", hierarchyMapHappyFlow))

 assertEquals(setOf("Skumtomten", "Dammråttan"), findGnomesBelow("Trötter", hierarchyMapHappyFlow))

 assertEquals(setOf("Dammråttan"), findGnomesBelow("Skumtomten", hierarchyMapHappyFlow))

 assertEquals(setOf<String>(), findGnomesBelow("Dammråttan", hierarchyMapHappyFlow))

 assertEquals(setOf<String>(), findGnomesBelow("Blyger", hierarchyMapHappyFlow))

 assertEquals(setOf("Rådjuret", "Nyckelpigan", "Haren", "Räven", "Gråsuggan", "Myran", "Bladlusen"),
              findGnomesBelow("Butter", hierarchyMapHappyFlow))

 assertEquals(setOf<String>(), findGnomesBelow("Rådjuret", hierarchyMapHappyFlow))

 assertEquals(setOf<String>(), findGnomesBelow("Nyckelpigan", hierarchyMapHappyFlow))

 assertEquals(setOf<String>(), findGnomesBelow("Haren", hierarchyMapHappyFlow))

 assertEquals(setOf("Gråsuggan", "Myran", "Bladlusen"), findGnomesBelow("Räven", hierarchyMapHappyFlow))

 assertEquals(setOf<String>(), findGnomesBelow("Gråsuggan", hierarchyMapHappyFlow))

 assertEquals(setOf("Bladlusen"), findGnomesBelow("Myran", hierarchyMapHappyFlow))
 }

 @Test
 fun fakeNamesInExistingMap() {
  assertEquals(setOf<String>(), findGnomesBelow("TEST1", hierarchyMapHappyFlow))
  assertEquals(setOf<String>(), findGnomesBelow("TEST2", hierarchyMapHappyFlow))
  assertEquals(setOf<String>(), findGnomesBelow("TEST3", hierarchyMapHappyFlow))
 }

 @Test
 fun allHierarchiesEmpty() {
  assertEquals(setOf<String>(), findGnomesBelow("Tomten", hierarchyMapEmpty))

  assertEquals(setOf<String>(), findGnomesBelow("Glader", hierarchyMapEmpty))

  assertEquals(setOf<String>(), findGnomesBelow("Tröger", hierarchyMapEmpty))

  assertEquals(setOf<String>(), findGnomesBelow("Trötter", hierarchyMapEmpty))

  assertEquals(setOf<String>(), findGnomesBelow("Skumtomten", hierarchyMapEmpty))

  assertEquals(setOf<String>(), findGnomesBelow("Dammråttan", hierarchyMapEmpty))

  assertEquals(setOf<String>(), findGnomesBelow("Blyger", hierarchyMapEmpty))

  assertEquals(setOf<String>(), findGnomesBelow("Butter", hierarchyMapEmpty))

  assertEquals(setOf<String>(), findGnomesBelow("Rådjuret", hierarchyMapEmpty))

  assertEquals(setOf<String>(), findGnomesBelow("Nyckelpigan", hierarchyMapEmpty))

  assertEquals(setOf<String>(), findGnomesBelow("Haren", hierarchyMapEmpty))

  assertEquals(setOf<String>(), findGnomesBelow("Räven", hierarchyMapEmpty))

  assertEquals(setOf<String>(), findGnomesBelow("Gråsuggan", hierarchyMapEmpty))

  assertEquals(setOf<String>(), findGnomesBelow("Myran", hierarchyMapEmpty))

 }

}