package i_introduction._3_Default_Arguments

import util.TODO
import util.doc2
import javax.print.DocFlavor

fun todoTask3(): Nothing = TODO(
        """
        Task 3.
        Several overloaded 'foo' functions in the class 'JavaCode3' can be replaced with one function in Kotlin.
        Change the declaration of the function 'foo' in a way that makes the code using 'foo' compile.
        You have to add 'foo' parameters and implement its body.
        Uncomment the commented code and make it compile.
    """,
        documentation = doc2(),
        references = { name: String -> JavaCode3().foo(name); foo(name) })

//fun foo(name: String): String = name
//fun foo(name: String, number: Int): String = "$name$number"  // name + number.toString()
//fun foo(name: String, toUpperCase: Boolean): String = name
//fun foo(name: String, number: Int, toUpperCase: Boolean): String = name

fun foo(name: String, number: Int = 42, toUpperCase: Boolean = false): String {
    val ret = "$name$number"

//    if (toUpperCase) { return ret.toUpperCase() } else { return ret }

    // return if (toUpperCase) { return { ret.toUpperCase() }

    val x = if (toUpperCase) {
        ret.toUpperCase()
    } else {
        ret
    }
    return x
}

/*
one solution
fun task3(): String {
//    todoTask3()
    return (foo(name ="a") +
            foo(name ="b", number = 1) +
            foo(name ="c", toUpperCase = true) +
            foo(name = "d", number = 2, toUpperCase = true))
}
*/


fun task3(): String = (
    foo(name = "a") +
    foo(name = "b", number = 1) +
    foo(name = "c", toUpperCase = true) +
    foo(name = "d", number = 2, toUpperCase = true)
)

