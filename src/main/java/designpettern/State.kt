package designpettern

open class WaterMachineState(open val machine: WaterMachine) {
    fun turnHeating() {
        if (this !is Heating) {
            println("turn heating.")
            machine.state = machine.heating
        } else {
            println("The State is already heating mode.")
        }
    }

    fun turnCooling() {
        if (this !is Cooling) {
            println("turn cooling.")
            machine.state = machine.cooling
        } else {
            println("The State is already cooling mode.")
        }
    }

    fun turnOff() {
        if (this !is Off) {
            println("turn off.")
            machine.state = machine.off
        } else {
            println("The State is already Off mode.")
        }
    }
}


class WaterMachine {
    var state: WaterMachineState
    var off = Off(this)
    var heating = Heating(this)
    var cooling = Cooling(this)

    init {
        this.state = off
    }

    fun turnHeating() {
        state.turnHeating()
    }

    fun turnCooling() {
        state.turnCooling()
    }

    fun turnOff() {
        state.turnOff()
    }
}

class Off(override val machine: WaterMachine) : WaterMachineState(machine)
class Heating(override val machine: WaterMachine) : WaterMachineState(machine)
class Cooling(override val machine: WaterMachine) : WaterMachineState(machine)

enum class Moment {
    EARLY_MORNING, //早上上班
    DRINKING_WATTER, //日常饮水
    INSTANCE_NOODLES, //泡面
    AFTER_WORK //下班
}

fun waterMachineOps(machine: WaterMachine, moment: Moment) {
    when (moment) {
        Moment.EARLY_MORNING,
        Moment.DRINKING_WATTER -> if (machine.state !is Cooling) {
            machine.turnCooling()
        }
        Moment.INSTANCE_NOODLES -> if (machine.state !is Heating) {
            machine.turnHeating()
        }
        Moment.AFTER_WORK -> if (machine.state !is Off) {
            machine.turnOff()
        }
        else -> Unit
    }
}


fun main() {
    val machine = WaterMachine()
    waterMachineOps(machine, Moment.DRINKING_WATTER)
    waterMachineOps(machine, Moment.INSTANCE_NOODLES)
    waterMachineOps(machine, Moment.DRINKING_WATTER)
    waterMachineOps(machine, Moment.AFTER_WORK)
}