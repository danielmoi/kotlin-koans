package i_introduction._0_Hello_World
// namespace for this file
// regardless of file location, being in the same PACKAGE, you have access to all global variables

import util.TODO
import util.doc0

// const doc0 = require('util.doc0')

// function declaration
// args: none (takes 0 args)
// return: nothing (returns nothing)
fun todoTask0(): Nothing = TODO(
    """
        Task 0.

        Read README.md to learn how to work with this project and check your solutions.

        Using 'documentation =' below the task description you can open the related part of the online documentation.
            Press 'Ctrl+Q'(Windows) or 'F1'(Mac OS) on 'doc0()' to call the "Quick Documentation" action;
            "See also" section gives you a link.
            You can see the shortcut for the "Quick Documentation" action used in your IntelliJ IDEA
            by choosing "Help -> Find Action..." (in the top menu), and typing the action name ("Quick Documentation").
            The shortcut in use will be written next to the action name.

        Using 'references =' you can navigate to the code mentioned in the task description.

        Let's start! Make the function 'task0' return "OK". Note that you can return expression directly.


    """,
    documentation = doc0(),
    references = { task0(); "OK" }
)

// inside a BLOCK scope function, you always have to use the "return" keyword
// in a LAMBDA it will automatically return the last expression
fun task0(): String {
//    return todoTask0()
    return "OK"
}

/*
we can also write:

fun task0() = "OK"
 */