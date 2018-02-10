package i_introduction._9_Extension_Functions

import util.TODO
import util.doc9

// declares an extension function that returns the last character
fun String.lastChar() = this.get(this.length - 1)


// 'this' refers to the receiver (String) and can be omitted
fun String.lastChar1() = get(length - 1)

fun useExtensionFunction() {
    // try Ctrl+Space "default completion" after the dot: lastChar() is visible
    "abc".lastChar()
}

// 'lastChar' is compiled to a static function in the class ExtensionFunctionsKt (see JavaCode9.useExtension)

fun todoTask9(): Nothing = TODO(
    """
        Task 9.
        Implement the extension functions Int.r(), Pair<Int, Int>.r()
        to support the following manner of creating rational numbers:
        1.r(), Pair(1, 2).r()
    """,
    documentation = doc9(),
    references = { 1.r(); Pair(1, 2).r(); RationalNumber(1, 9) })

data class RationalNumber(val numerator: Int, val denominator: Int)


// we are adding an extension function "r" onto the class "Int"
/*
My initial solution:
fun Int.r(n: Int, d: Int): RationalNumber = RationalNumber(n,d)
fun Pair<Int, Int>.r(n: Int, d: Int): RationalNumber = RationalNumber(n,d)

Error:
Error:(28,24) Kotlin: No value passed for parameter 'n'
Error:(28,24) Kotlin: No value passed for parameter 'd'


 */



// Looking at the tests, we can see that .r() has no arguments passed in
// so, we have to use "this"
fun Int.r(): RationalNumber = RationalNumber(this, 1)

/*
fun Pair<Int, Int>.r(): RationalNumber = RationalNumber(this, this)

Then I tried default completion!! CTRL+SPACE, and it showed this.first?!!!!!
 */
// we are adding an extension function "r" onto the class "Pair"
fun Pair<Int, Int>.r(): RationalNumber = RationalNumber(this.first, this.second)


