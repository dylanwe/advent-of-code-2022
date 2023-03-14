package days.day02

import java.io.File

fun part1(input: List<String>): Int {
    var points = 0

    for (value in input) {
        points += when (value) {
            "A Y", "B Z", "C X" -> 6 // win
            "A X", "B Y", "C Z" -> 3 // draw
            else -> 0 // loss
        }

        val base = 'X'.code - 1
        points += value
            .split(" ")[1]
            .first().code - base
    }
    return points
}

fun part2(input: List<String>): Int {
	var points = 0

	for (outcome in input) {
		val (otherMove, _, yourMove) = outcome.toCharArray()
		val outcome = when (yourMove) {
			'Y' -> 3 // draw
			'Z' -> 6 // win
			else -> 0 // loss
		}

        // possible scores
        val scores = arrayOf(1,2,3)

        // base move
        val base = 'A'

        // calculate move value based on win or loss
        val move = when(outcome) {
            3 -> scores[otherMove - base]
            6 -> scores[((otherMove - base) + 1) % scores.size]
            else -> scores[((otherMove - base) + 2) % scores.size]
        }

        points += move + outcome
	}

	return points
}

fun main() {
    val input = File("src/main/kotlin/days/day02/input.txt").readLines()
    println(part1(input))
}
