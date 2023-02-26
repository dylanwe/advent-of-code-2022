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

fun main() {
    val input = File("src/main/kotlin/days/day02/input.txt").readLines()
    println(part1(input))
}