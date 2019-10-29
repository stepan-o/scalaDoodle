package vehicle

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
