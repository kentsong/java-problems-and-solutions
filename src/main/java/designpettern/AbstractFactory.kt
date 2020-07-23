package designpettern

//抽象工厂
abstract class AbstractFactory {
    abstract fun produce(): Computer

    companion object {
        operator fun invoke(factory: AbstractFactory): AbstractFactory {
            return factory
        }
    }
}

//伴生内联抽象工厂
//abstract class designpettern.AbstractFactory {
//    abstract fun produce(): designpettern.Computer
//
//    companion object {
//        inline operator fun <reified T : designpettern.Computer> invoke(): designpettern.AbstractFactory {
//            return when (T::class) {
//                designpettern.Dell::class -> designpettern.DellFactory()
//                designpettern.Asus::class -> designpettern.AsusFactory()
//                else -> designpettern.AcerFactory()
//            }
//        }
//    }
//}

class Dell : Computer {
    override val cpu: String = ""
}

class Asus : Computer {
    override val cpu: String = ""
}

class DellFactory : AbstractFactory() {
    override fun produce(): Computer {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

class AsusFactory : AbstractFactory() {
    override fun produce(): Computer {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

class AcerFactory : AbstractFactory() {
    override fun produce(): Computer {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

fun main() {
    val dellFactory = AbstractFactory(DellFactory())
//    val dellFactory = designpettern.AbstractFactory<designpettern.Dell>()
}