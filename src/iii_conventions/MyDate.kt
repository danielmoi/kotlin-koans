package iii_conventions

// Needed to add ": Comparable<MyDate>"
data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int)
    : Comparable<MyDate>{

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


// SOLUTION 1 -
// compareTo, by implementing 'ClosedRange' interface
// iterator, by using an extra class to implement 'Iterator<MyDate>'

// We are using the "compareTo" method on the "MyDate" class above
// "start" hides member of supertype "ClosedRange" and needs "override" modifier
// we are using the "contains" method on ClosedRange
// this is called making OUR class "DateRage" IMPLEMENT the "ClosedRange" INTEFACE
// from the standard library
class DateRange(override val start: MyDate, override val endInclusive: MyDate): ClosedRange<MyDate>, Iterable<MyDate>{
    override fun iterator(): Iterator<MyDate> {
        return DateIterator(this)
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}



// SOLUTION 2
// compareTo, by writing our own "contains" method
// iterator, by using an object expression

// We are using the "compareTo" method on the "MyDate" class above
// "start" hides member of supertype "ClosedRange" and needs "override" modifier
class DateRange1(val start: MyDate, val endInclusive: MyDate): Iterable<MyDate> {
    // this was the error I got:
    // "operator" modifier is required on "contains"
    operator fun contains(d: MyDate): Boolean = start <= d && d <= endInclusive

    // This goes here, and not in MyDate
    // This is the guts behind implementing ".."
    override fun iterator(): Iterator<MyDate> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}

class DateIterator(val dateRange: DateRange) : Iterator<MyDate> {
    var current: MyDate = dateRange.start
    override fun next(): MyDate {
        val result = current
        current = current.addTimeIntervals(TimeInterval.DAY, 1)
        return result
    }
    override fun hasNext(): Boolean = current <= dateRange.endInclusive
}