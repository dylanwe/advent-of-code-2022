package days.day02

import java.io.File

fun part1(input: List<String>): Int {
    var points = 0

    for (game in input) {
        when (game) {
            "A X" -> points += 1 + 3
            "A Y" -> points += 2 + 6
            "A Z" -> points += 3 + 0
            "B X" -> points += 1 + 0
            "B Y" -> points += 2 + 3
            "B Z" -> points += 3 + 6
            "C X" -> points += 1 + 6
            "C Y" -> points += 2 + 0
            "C Z" -> points += 3 + 3
        }
    }
    return points
}

fun main() {
    val input = File("src/main/kotlin/days/day02/input.txt").readLines()
    println(part1(input))
}


// A, X = 1
// B, Y = 2
// C, Z = 3

// loss = 0
// draw = 3
// win  = 6