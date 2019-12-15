import java.time.LocalDate
import java.time.Year
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit
import java.util.*

fun main() {

    val scanner = Scanner(System.`in`) // to get user input
    val today = LocalDate.now() // to get current date / time

    // set date format
    val formatter = DateTimeFormatter.ofPattern("M/d/yyyy")

    // display today's date formatted
    val textToday = today.format(formatter)
    println("Today's date is: $textToday")

    // get info from user
    println("What month were you born in? (Enter as number: January = 1)")
    val myMonth:Int = scanner.nextInt()
    println("What day were you born? ")
    val myDay:Int = scanner.nextInt()
    val myYear = today.year // assign year to current year
    val thisMonth = today.month

    // assign information to variable birthday
    var birthday: LocalDate = LocalDate.of(myYear, myMonth, myDay)

    // if birthday already happened this year, add one to year
    if (birthday.isBefore(today)) {
        birthday = birthday.plusYears(1)
    }

    val nextBirthday = birthday.format(formatter)
    // calculate days till next birthday

    val daysToBirthday = today.until(birthday, ChronoUnit.DAYS)

    if (myMonth == thisMonth.value && myDay == today.dayOfMonth) {
        println("Happy Birthday!")
    } else {
        println("Your next birthday is: $nextBirthday")
        println("There are $daysToBirthday days till your next birthday!")
    }

}


