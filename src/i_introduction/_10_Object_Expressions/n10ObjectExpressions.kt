package i_introduction._10_Object_Expressions

import util.TODO
import util.doc10
import java.util.*

fun todoTask10(): Nothing = TODO(
    """
        Task 10.
        Read about object expressions that play the same role in Kotlin
        as anonymous classes in Java.

        Add an object expression that provides a comparator to
        sort a list in a descending order using 'java.util.Collections' class.

        In Kotlin you use Kotlin library extensions instead of java.util.Collections,
        but this example is still a good demonstration of mixing Kotlin and Java code.
    """,
    documentation = doc10()
)

/*
fun task10(): List<Int> {
    val arrayList = arrayListOf(1, 5, 2)
    // copied this
    // not sure what "override fun compare(...)" means
    // then got error: "Convert to lambda"
    Collections.sort(arrayList, object : Comparator<Int> {
        override fun compare(x: Int, y: Int) = y - x
    })
    return arrayList
}

# 2
fun task10(): List<Int> {
    val arrayList = arrayListOf(1, 5, 2)
    // copied this
    // Redundant SAM constructor
    Collections.sort(arrayList, Comparator { x, y -> y - x })
    return arrayList
}
*/
fun task10(): List<Int> {
    val arrayList = arrayListOf(1, 5, 2)

    // our lambda
    // so ".sort" passes 2 elements on each pass through the array?

    // But, now, this isn't an object expression, right?
    Collections.sort(arrayList, { x, y -> y - x })
    return arrayList
}

