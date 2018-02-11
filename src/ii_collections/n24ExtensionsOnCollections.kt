package ii_collections

import util.TODO

fun todoTask24(): Nothing = TODO(
    """
        Task 24.
        The function should do the same as '_24_JavaCode.doSomethingStrangeWithCollection'.
        Replace all invocations of 'todoTask24()' with the appropriate code.
    """,
        references = { c: Collection<String> -> _24_JavaCode().doSomethingStrangeWithCollection(c) }
)

fun doSomethingStrangeWithCollection(collection: Collection<String>): Collection<String>? {
    val groupsByLength = collection.groupBy { str -> str.length }
    println("groupsByLength:$groupsByLength")

    return groupsByLength.values.maxBy { group -> group.size }
}

/*
groupsByLength:{1=[a, c], 2=[bb]}
groupsByLength:{0=[, , , ], 1=[a], 2=[bb], 3=[ccc], 4=[dddd]}
groupsByLength:{1=[a, c], 2=[bb, dd]}
groupsByLength:{}
groupsByLength:{1=[a]}
 */

/*
class _24_JavaCode : JavaCode() {
    fun doSomethingStrangeWithCollection(collection: Collection<String>): Collection<String>? {
        val groupsByLength = Maps.newHashMap()
        for (s in collection) {
            var strings: MutableList<String>? = groupsByLength.get(s.length)
            if (strings == null) {
                strings = Lists.newArrayList()
                groupsByLength.put(s.length, strings)
            }
            strings.add(s)
        }

        var maximumSizeOfGroup = 0
        for (group in groupsByLength.values) {
            if (group.size > maximumSizeOfGroup) {
                maximumSizeOfGroup = group.size
            }
        }

        for (group in groupsByLength.values) {
            if (group.size == maximumSizeOfGroup) {
                return group
            }
        }
        return null
    }
}
*/