package days.day06

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day06KtTest {
	@Test
	fun `should put marker at 5`() {
		val input = "bvwbjplbgvbhsrlpgdmjqwftvncz"
		val actual = findFirstMarker(input)

		assertEquals(
			5,
			actual
		)
	}

	@Test
	fun `should put marker at 6`() {
		val input = "nppdvjthqldpwncqszvftbrmjlhg"
		val actual = findFirstMarker(input)

		assertEquals(
			6,
			actual
		)
	}

	@Test
	fun `should put marker at 10`() {
		val input = "nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg"
		val actual = findFirstMarker(input)

		assertEquals(
			10,
			actual
		)
	}

	@Test
	fun `should put marker at 11`() {
		val input = "zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw"
		val actual = findFirstMarker(input)

		assertEquals(
			11,
			actual
		)
	}
}