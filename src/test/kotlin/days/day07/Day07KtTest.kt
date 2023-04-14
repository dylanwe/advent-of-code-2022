package days.day07

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.io.File

class Day07KtTest {

	@Test
	fun testRead() {
		val input = File("src/test/kotlin/days/day07/input.txt").readLines()
		val value = part1(input, 100_000)
		val expected = 95437

		assertEquals(expected, value)
	}
}
