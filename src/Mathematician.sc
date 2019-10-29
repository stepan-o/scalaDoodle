import vehicle.{SportsUtilityVehicle, Vehicle}

class Vehicle(vin: String, manufacturer: String, model: String, modelYear:Int, finalAssemblyCountry: String) {
  private val createTs = System.currentTimeMillis()  // example of encapsulation (hiding internals)
  def start(): Unit = {println("Starting...")}  // behaviour
  def stop(): Unit = {println("Stopping...")}  // behaviour
}


class SportsUtilityVehicle(vin: String, manufacturer: String,
                           model: String, modelYear: Int, finalAssemblyCountry: String,
                           fourWheelDrive: Boolean) extends Vehicle(vin, manufacturer, model, // inheritance example
  modelYear, finalAssemblyCountry) {
  def enableFourWheelDrive(): Unit = { if (fourWheelDrive) println("Enabling 4 wheel drive...")}
  override def start(): Unit = {
    enableFourWheelDrive()
    println("Starting SUV...")
  }
}

def square(x: Int) = x * x

square(2)

val theAuto = new Vehicle("WAUZZZ8K6AA123456", "Audi",
  "A4", 2009, "Germany")

theAuto.isInstanceOf[Vehicle]

theAuto.isInstanceOf[Int]

theAuto.start()

theAuto.stop()

val theSUV = new SportsUtilityVehicle("WAUZZZ8K6A654321", "Audi",
"Q7", 2019, "Germany", true)

theSUV.start()