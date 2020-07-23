package designpettern

import kotlin.properties.Delegates

interface StockUpdateListemer {
    fun onRise(price: Int)
    fun onFall(price: Int)
}

class StockDisplay2 : StockUpdateListemer {
    override fun onRise(price: Int) {
        println("onRise to ${price}")
    }

    override fun onFall(price: Int) {
        println("onFall to ${price}")
    }
}

//可观察属性被附值
class StockUpdate2 {
    val listeners = mutableSetOf<StockUpdateListemer>()

    var price: Int by Delegates.observable(0) { _, old, new ->
        listeners.forEach({
            if (new > old) it.onRise(price) else it.onFall(price)
        })
    }

    var num: Int by Delegates.vetoable(0) {
        _, old, new -> new > 0
    }
}

fun main() {
    val su = StockUpdate2()
    val sd = StockDisplay2()
    su.listeners.add(sd)
    su.price = 100
    println(su.price)
    su.price = 98
    println(su.price)

    su.num = 1
    println(su.num)
    su.num = -1
    println(su.num)

}