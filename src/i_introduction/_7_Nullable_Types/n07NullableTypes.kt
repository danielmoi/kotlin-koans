package i_introduction._7_Nullable_Types

import util.TODO
import util.doc7

fun test() {
    val s: String = "this variable cannot store null references"

    // this variable can store null references
    val q: String? = null

    if (q != null) q.length      // you have to check to dereference

    // create variable "i"
    val i: Int? = q?.length      // null

    // create variable "j"
    val j: Int = q?.length ?: 0  // 0
}

fun todoTask7(client: Client?, message: String?, mailer: Mailer): Nothing = TODO(
    """
        Task 7.
        Rewrite JavaCode7.sendMessageToClient in Kotlin, using only one 'if' expression.
        Declarations of Client, PersonalInfo and Mailer are given below.
    """,
    documentation = doc7(),
    references = { JavaCode7().sendMessageToClient(client, message, mailer) }
)

fun sendMessageToClient(
        client: Client?, message: String?, mailer: Mailer
) {
//    todoTask7(client, message, mailer)

    // JavaCode7.sendMessageToClient calls mailer.sendMessage, with an EMAIL and MESSAGE
    // we need to source those 2 variables somehow
    // "message" comes directly from the "message" argument
    // "email" is derived from the "client" argument
    val email = client?.personalInfo?.email

    if (email != null && message !== null) {
        mailer.sendMessage(email, message)
    }
}

class Client (val personalInfo: PersonalInfo?)
class PersonalInfo (val email: String?)

interface Mailer {
    fun sendMessage(email: String, message: String)
}
