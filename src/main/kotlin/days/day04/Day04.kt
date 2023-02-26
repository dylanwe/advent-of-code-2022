package days.day04

import java.io.File

fun part1(input: List<String>): Int {
	var incasedSections = 0

	input.forEach { line ->
		val (sectionOne, sectionTwo) = line.split(",")
			.map { section ->
				section.split("-")
					.map { it.toInt() }
			}
			.toList()

		if (isSectionContained(sectionOne, sectionTwo) || isSectionContained(sectionTwo, sectionOne)) {
			incasedSections++
		}
	}

	return incasedSections
}

fun isSectionContained(sectionOne: List<Int>, sectionTwo: List<Int>): Boolean {
	return (
			sectionOne[0] in sectionTwo[0]..sectionTwo[1] &&
					sectionOne[1] in sectionTwo[0]..sectionTwo[1]
			)
}

fun main() {
	val input = File("src/main/kotlin/days/day04/input.txt").readLines()
	val answer = part1(input)
	println(answer)
}