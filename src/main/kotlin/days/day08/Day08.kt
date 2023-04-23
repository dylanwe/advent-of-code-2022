package days.day08

import java.io.File

/**
 * Create an empty grid
 */
private fun createGrid(width: Int, height: Int): List<MutableList<Int>> {
	val grid = mutableListOf<MutableList<Int>>()
	for (i in 0..height) {
		// Fill the grid with a list as big as the width with all zeroes
		grid.add(MutableList(width + 1) { 0 })
	}
	return grid
}

/**
 * Find all trees looking from the left and right sides
 */
private fun horizontalTrees(input: List<String>, grid: List<MutableList<Int>>) {
	// Go over every row
	for (row in input.indices) {
		var left = 0
		var right = input[row].length - 1

		var biggestLeft = -1
		var biggestRight = -1

		while (left < right) {
			// Get the numbers at the left and right side
			val leftNum = input[row][left].toString().toInt()
			val rightNum = input[row][right].toString().toInt()

			// If the left is bigger than the current biggest left than we can see the tree
			if (leftNum > biggestLeft) {
				biggestLeft = leftNum
				grid[row][left] = 1
			}
			// If the right is bigger than the current biggest right than we can see the tree
			if (rightNum > biggestRight) {
				biggestRight = rightNum
				grid[row][right] = 1
			}

			// Move whichever has the smallest biggest number or left
			if (biggestLeft < biggestRight) {
				left++
			} else {
				right--
			}
		}
	}
}

/**
 * Find all trees looking from the top and bottom
 */
private fun verticalTrees(input: List<String>, grid: List<MutableList<Int>>) {
	// Go over every column
	for (col in input[0].indices) {
		var top = 0
		var bottom = input.size - 1

		var biggestTop = -1
		var biggestBottom = -1

		while (top < bottom) {
			// Get the numbers at the top and bottom side
			val topNum = input[top][col].toString().toInt()
			val bottomNum = input[bottom][col].toString().toInt()

			// If the top is bigger than the current biggest top than we can see the tree
			if (topNum > biggestTop) {
				biggestTop = topNum
				grid[top][col] = 1
			}
			// If the bottom is bigger than the current biggest bottom than we can see the tree
			if (bottomNum > biggestBottom) {
				biggestBottom = bottomNum
				grid[bottom][col] = 1
			}

			// Move whichever has the smallest biggest number or top
			if (biggestTop < biggestBottom) {
				top++
			} else {
				bottom--
			}
		}
	}
}

fun solve(input: List<String>): Int {
	val grid = createGrid(input[0].length - 1, input.size - 1)
	horizontalTrees(input, grid)
	verticalTrees(input, grid)

	return grid.flatten().sum()
}

fun main() {
	val input = File("src/main/kotlin/days/day08/input.txt").readLines()
	val result = solve(input)
	println(result)
}