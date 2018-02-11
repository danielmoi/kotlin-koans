package iii_conventions

// Needed to add ": Comparable<MyDate>"
data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {

    override fun compareTo(other: MyDate) = when {
        year != other.year -> year - other.year
        month != other.month -> month - other.month
        else -> dayOfMonth - other.dayOfMonth
    }

}
/*
This is incorrect syntax:

                                                     Remove this
                                                      |
operator fun MyDate.rangeTo(other: MyDate): DateRange = {
    return DateRange(this, other)
}
 */
operator fun MyDate.rangeTo(other: MyDate): DateRange {
    return DateRange(this, other)
}

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}


// SOLUTION 1 - implement 'ClosedRange' interface

// We are using the "compareTo" method on the "MyDate" class above
// "start" hides member of supertype "ClosedRange" and needs "override" modifier
// we are using the "contains" method on ClosedRange
// this is called making OUR class "DateRage" IMPLEMENT the "ClosedRange" INTEFACE
// from the standard library
class DateRange1(override val start: MyDate, override val endInclusive: MyDate): ClosedRange<MyDate>



// SOLUTION 2 – add our own "contains" method

// We are using the "compareTo" method on the "MyDate" class above
// "start" hides member of supertype "ClosedRange" and needs "override" modifier
class DateRange(val start: MyDate, val endInclusive: MyDate) {
    // this was the error I got:
    // "operator" modifier is required on "contains"
    operator fun contains(d: MyDate): Boolean = start <= d && d <= endInclusive

}
