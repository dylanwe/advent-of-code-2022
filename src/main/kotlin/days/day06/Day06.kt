package days.day06

import java.io.File


/**
 * Find the marker which is after 4 sequential unique characters
 */
fun findFirstMarker(input: String): Int {
	// store the input character and its index
	var map: MutableMap<Char, Int> = HashMap()

	for (i in input.indices) {
		if (map.size == 4) break

		val currentChar = input[i]

		if (map.containsKey(currentChar)) {
			// remove all characters that come before or are the duplicate character
			map = map.filterValues { it > map[currentChar]!! }
				.toMutableMap()
		}

		map[currentChar] = i
	}

	// return the highest index + 1 or the current loop position + 1
	return map.maxOf { it.value } + 1
}

fun main() {
	val input = File("src/main/kotlin/days/day06/input.txt").readText()

	println(findFirstMarker(input = input))
}