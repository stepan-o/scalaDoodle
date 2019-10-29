package vehicle

class Vehicle(vin: String, manufacturer: String, model: String, modelYear:Int, finalAssemblyCountry: String) {
private val createTs = System.currentTimeMillis()  // example of encapsulation (hiding internals)
def start(): Unit = {println("Starting...")}  // behaviour
def stop(): Unit = {println("Stopping...")}  // behaviour
}

