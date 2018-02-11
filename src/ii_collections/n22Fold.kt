package ii_collections

fun example9() {
    val result = listOf(1, 2, 3, 4).fold(1, { partResult, element -> element * partResult })
    result == 24
}

// The same as
fun whatFoldDoes(): Int {
    var result = 1
    listOf(1, 2, 3, 4).forEach { element -> result = element * result}
    return result
}

fun Shop.getSetOfProductsOrderedByEveryCustomer(): Set<Product> {
    // Return the set of products ordered by every customer

    // Add them all, then remove the ones that are zero?

    // starting with customers

    // NB. "allOrderedProducts" is in n14FilterMap

    // But here it is again
    val allOrderedProducts = customers.flatMap { it.orderedProducts }.toSet()

    return customers.fold(allOrderedProducts, {
        orderedByAll, customer ->

//            customer.orders.flatMap { it.products }.filter {  }

//            val orderedProducts = customer.orders.flatMap { it.products }.toSet()
//            orderedByAll.intersect(orderedProducts)

            // gotta use ".intersect"...
            orderedByAll.intersect(customer.orderedProducts)
        
    })
}
