package designpettern

import java.util.*

class StockUpdate : Observable() {
    val observers = mutableSetOf<Observer>()

    fun setStockChanged(price: Int) {
        this.observers.forEach {
            it.update(this, price)
        }
    }
}

class StockDisplay : Observer {
    override fun update(o: Observable?, arg: Any?) {
        if (o is StockUpdate) {
            print("The latest stock price is ${arg}.")
        }
    }
}

fun main() {
    val su = StockUpdate()
    val sd = StockDisplay()
    su.observers.add(sd)
    su.setStockChanged(100)
}