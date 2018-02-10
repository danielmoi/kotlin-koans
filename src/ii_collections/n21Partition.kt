package ii_collections

fun example8() {
    val numbers = listOf(1, 3, -4, 2, -11)

    // The details (how multi-assignment works) will be explained later in the 'Conventions' task
    // because of the "()", "positive" and "negative" are both LISTS
    val (positive, negative) = numbers.partition { it > 0 }

    positive == listOf(1, 3, 2)
    negative == listOf(-4, -11)
}

fun Shop.getCustomersWithMoreUndeliveredOrdersThanDelivered1(): Set<Customer> {
    // Return customers who have more undelivered orders than delivered

//    val (delivered, undelivered) = this.customers.flatMap { it.orders }.partition { it.isDelivered }

//    val (more, less) = this.customers.partition { it.orders.partition { it.isDelivered == true } }

//    fun magic(customer: Customer): Boolean {
//        val (delivered, notDelivered) = customer.orders.partition { it.isDelivered }
//        print(delivered)
//        print(notDelivered)
//        return notDelivered > delivered
//    }

//    return this.customers.filter { customer ->
//        val (delivered, notDelivered) = customer.orders.partition { it.isDelivered }
//        return delivered > notDelivered
//    }.toSet()

//    return this.customers.filter { customer ->
//        val (delivered) = customer.orders.partition { it.isDelivered }
//    }.toSet()

    fun hasMoreUndelivered(customer: Customer): Boolean {
        val (delivered, notDelivered) = customer.orders.partition {
            it.isDelivered == true
        }
        return notDelivered.count() > delivered.count()
    }

    val (more) = this.customers.partition { hasMoreUndelivered(it) }

    return more.toSet()
}

// Working solution, before consulting resolutions
fun Shop.getCustomersWithMoreUndeliveredOrdersThanDelivered2(): Set<Customer> {
    fun hasMoreUndelivered(customer: Customer): Boolean {
        val (delivered, notDelivered) = customer.orders.partition { it.isDelivered }
        return notDelivered.count() > delivered.count()
    }

    val (more) = this.customers.partition { hasMoreUndelivered(it) }

    return more.toSet()
}

// 1. Use "filter" - no need to use 2 partitions
// 2. Do it all inline (use a lambda) - remember that lambdas can be MULTI-line
fun Shop.getCustomersWithMoreUndeliveredOrdersThanDelivered3(): Set<Customer> {
    // "filter" returns one subset list
    return this.customers.filter {
        // we should use "partition" here, because we need TWO lists, to compare, to generate a boolean
        val (delivered, notDelivered) = it.orders.partition { it.isDelivered }

        // size == count()
        notDelivered.size > delivered.size
    }.toSet()
}

// equivalent, but using the longer "customer" syntax, instead of "it"
fun Shop.getCustomersWithMoreUndeliveredOrdersThanDelivered(): Set<Customer> {
    // "filter" returns one subset list
    return this.customers.filter { customer ->
        // we should use "partition" here, because we need TWO lists, to compare, to generate a boolean
        val (delivered, notDelivered) = customer.orders.partition { it.isDelivered }

        // size == count()
        notDelivered.size > delivered.size
    }.toSet()
}

