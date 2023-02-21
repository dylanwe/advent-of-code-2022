
import java.text.SimpleDateFormat
import java.util.*


fun main() {
    val sdf = SimpleDateFormat("EEEE, dd MMM")
    val d = Date()
    val dayOfTheWeek = sdf.format(d)

    println(dayOfTheWeek)
}