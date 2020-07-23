package designpettern

interface Computer {
    val cpu: String

    companion object Factory{
        operator fun invoke(type: ComputerType) : Computer {
            return when (type){
                ComputerType.PC -> PC()
                else -> Server()
            }
        }
    }
}

//拓展伴生对象方法
fun Computer.Factory.fromCPU(cpu:String) : ComputerType? = when(cpu){
    "Core" -> ComputerType.PC
    else -> ComputerType.Server
}


class PC() : Computer {
    override val cpu: String
        get() = "pc"
}
class Server(): Computer {
    override val cpu: String = "server"
}

enum class ComputerType {
    PC, Server
}

fun main() {
    //伴生对象静态工厂
    var computer = Computer(ComputerType.PC)
    //拓展伴生对象方法
    var server = Computer.fromCPU("Core")

}