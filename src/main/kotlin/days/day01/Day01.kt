package days.day01

import java.io.File

fun parseInput(input: String): List<Int> {
    return input.split("\n\n").map { elf ->
        elf.lines().sumOf { it.toInt() }
    }
}

fun part1(input: String): Int {
    return parseInput(input).max()
}

fun part2(input: String, top: Int): Int {
    return parseInput(input)
        .sortedDescending()
        .take(top)
        .sum()
}

fun main() {
    val text = File("src/main/kotlin/days/day01/input.txt").readText()
    val maxElf = part1(input = text)
    val maxN = part2(input = text, 3)

    println(maxElf)
    println(maxN)
}