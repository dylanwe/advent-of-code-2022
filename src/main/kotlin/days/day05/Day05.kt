package days.day05

import java.io.File
import java.util.*

private fun makeStacks(grid: String): List<Stack<Char>> {
	val stacks = arrayListOf<Stack<Char>>()
	val emptySpace = "[?]"
	val formattedGrid = grid
		.replace("    ", emptySpace)
		.replace(" ", "")
		.split("\n")
		.map { it.chunked(3) }
		.toMutableList()

	// remove numbers of the bottom
	formattedGrid.removeAt(formattedGrid.size - 1)

	// make stacks
	for (col in 0 until formattedGrid[0].size) {
		stacks.add(Stack())
		for (row in formattedGrid.size - 1 downTo 0) {
			if (formattedGrid[row][col] != emptySpace) {
				val char = formattedGrid[row][col][1]
				stacks[stacks.size - 1].add(char)
			}
		}
	}

	return stacks
}

private data class Instruction(
	var moveAmount: Int,
	val fromStack: Int,
	val toStack: Int
)

private fun instructions(instructionsText: String): List<Instruction> {
	return instructionsText
		.split("\n")
		.map {
			Regex("[0-9]+").findAll(it)
				.map(MatchResult::value)
				.map { som -> som.toInt() }
				.toList()
		}
		.filter { it.isNotEmpty() }
		.map { Instruction(it[0], it[1], it[2]) }
		.toList()
}

private fun followInstructions(stacks: List<Stack<Char>>, instructions: List<Instruction>): List<Stack<Char>> {
	instructions.forEach { instruction ->
		for (i in 1..instruction.moveAmount) {
			stacks[instruction.toStack - 1].add(stacks[instruction.fromStack - 1].pop())
		}
	}

	return stacks
}

private fun part1(input: String) {
	val (grid, instructionsText) = input.split("\n\n")
	var stacks = makeStacks(grid)
	val instructions = instructions(instructionsText)
	stacks = followInstructions(stacks, instructions)

	var answer = ""
	stacks.forEach {
		answer += it.pop()
	}

	println(answer)
}

fun main() {
	val input = File("src/main/kotlin/days/day05/input.txt").readText()
	part1(input)
}