package days.day07

import java.io.File
import java.util.LinkedList

data class DirectoryNode(
	var parent: DirectoryNode?,
	var size: Int,
	var subDirectories: HashMap<String, DirectoryNode>
) {
	override fun toString(): String {
		return StringBuilder()
			.append("size: $size \n")
			.append("subs: ${subDirectories.keys} \n")
			.toString()
	}
}

enum class LineType(val type: String) {
	DIR("dir"),
	CMD("$"),
}

fun part1(lines: List<String>, limit: Int): Int {
	// Skip first 2 lines
	val lines = lines.subList(2, lines.size)

	val startDirectory = DirectoryNode(
		parent = null,
		size = 0,
		subDirectories = hashMapOf()
	)

	buildFileTree(startDirectory, lines)
	correctFileTree(startDirectory)
	return turnToList(startDirectory, limit).sumOf { dir -> dir.size }
}

/**
 * Create a tree from the given console output
 */
private fun buildFileTree(start: DirectoryNode, lines: List<String>) {
	var currentDirectory: DirectoryNode = start

	for (line in lines) {
		val lineStart = line.split(" ")[0]

		when (lineStart) {
			LineType.DIR.type -> {
				// Add new directory as a subdirectories of the current directory
				val dirName = line.split(" ")[1]
				currentDirectory.subDirectories[dirName] = DirectoryNode(
					parent = currentDirectory,
					size = 0,
					subDirectories = hashMapOf()
				)
			}

			LineType.CMD.type -> {
				val command = line.split(" ")[1]

				if (command == "cd") {
					val dir = line.split(" ")[2]
					currentDirectory = if (dir == "..") {
						currentDirectory.parent!!
					} else {
						currentDirectory.subDirectories[dir]!!
					}
				}
			}

			else -> {
				val fileSize = line.split(" ")[0].toIntOrNull() ?: 0
				currentDirectory.size += fileSize
			}
		}
	}
}

/**
 * Make sure subdirectory sizes are added to parent directory sizes
 */
private fun correctFileTree(directoryNode: DirectoryNode) {
	if (directoryNode.subDirectories.isEmpty()) return

	for (sub in directoryNode.subDirectories) {
		correctFileTree(sub.value)
	}

	directoryNode.size += directoryNode.subDirectories
		.values
		.sumOf { dir -> dir.size }
}

/**
 * Add every directory in the tree to a list if the directory is within the given limit
 */
private fun turnToList(currentDirectory: DirectoryNode, limit: Int): LinkedList<DirectoryNode> {
	if (currentDirectory.subDirectories.isEmpty()) {
		return LinkedList()
	}

	// Start with empty list
	val tempList = LinkedList<DirectoryNode>()

	// Go over children recursively and add to the list if a directory is within limit
	for (directory in currentDirectory.subDirectories.values) {
		tempList.addAll(turnToList(directory, limit))
		if (directory.size <= limit) tempList.add(directory)
	}

	return tempList
}

fun main() {
	val lines = File("src/main/kotlin/days/day07/input.txt").readLines()
	val limit = 100_000
	val message = part1(lines, limit)
	println(message)
}