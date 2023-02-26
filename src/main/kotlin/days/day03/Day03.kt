package days.day03

import java.io.File

fun part1(input: List<String>): Int {
	var sum = 0

	input.forEach { line ->
		val firstCompartment = line
			.substring(0, line.length / 2)
			.toSet()

		val secondCompartment = line
			.substring(line.length / 2, line.length)
			.toSet()

		val commonItem = firstCompartment
			.first { x -> secondCompartment.contains(x) }
			.code

		val lowercaseSubtract = 'a'.code - 1 // get one code below a as base
		val uppercaseSubtract = 'A'.code - 1 // get one code below A as base

		sum += if (commonItem > lowercaseSubtract) {
			commonItem - lowercaseSubtract
		} else {
			commonItem - uppercaseSubtract + 26
		}
	}

	return sum
}

fun main() {
	val input = File("src/main/kotlin/days/day03/input.txt").readLines()

	val sum = part1(input)
	println(sum)
}