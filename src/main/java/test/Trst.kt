package test

fun foo() {
    val ints = arrayOf(1, 2, 3, 4, 5, 6)

    ints.forEach lit@ {
        if (it == 3) return@lit
        println(it)
    }
}

fun foo2() {
    val ints = arrayOf(1, 2, 3, 4, 5, 6)
    ints.forEach(fun(value: Int) {
        if (value == 2) return
        print(value)
    })
}

fun main() {
    foo2()
}