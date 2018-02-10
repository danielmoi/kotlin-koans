package ii_collections

fun example() {

    // flatMap means 1. Flatten, then 2. Map
    val result = listOf("abc", "12").flatMap { it.toList() }

    result == listOf('a', 'b', 'c', '1', '2')
}

val Customer.orderedProducts: Set<Product> get() {
    // Return all products this customer has ordered

    // we can't do this.orders.products, because it is ".products" for EACH order

    // Q: Why do we need to use "flatMap" here?
    val x = this.orders.flatMap { it.products }.toSet()
    println(x)
    return x
}

val Shop.allOrderedProducts: Set<Product> get() {
    // Return all products that were ordered by at least one customer
    // ie. a group of all ordered products

    // use the ".orderedProducts" that we just made before!
    return this.customers.flatMap { it.orderedProducts }.toSet()
}
