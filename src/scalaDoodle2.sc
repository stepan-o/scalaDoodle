/* --------------------------------*/
/*----------- Arrays --------------*/
/* Mixed data types */
println("Array operations:")
println()
var myArray = Array(2, 5, "apple", 78)
println(myArray.head)
println(myArray(0))
println(myArray(2))
println(myArray.slice(0, 3))
myArray :+= "last words"
println(myArray.last)
myArray +:= "a new beginning"
println(myArray.head)

/* Numeric */
var myNewArray = Array(1, 2, 3, 4, 5)
println(myNewArray.max)
println(myNewArray.min)
println(myNewArray.sum)
println(myNewArray.product)

/*  Looping over arrays */
println("Looping over myNewArray")
var iteration = 0
println("Loop Start: Iteration:",
  iteration)
for (i <- myNewArray) {
  iteration += 1
  println("Iteration:", iteration)
  println(i)
}

/* Mapping array elements */
val myNewArrayTripled =
  myNewArray.map(i => i * 3)
for (i <- myNewArrayTripled) {
  iteration += 1
  println("Iteration:", iteration)
  println(i)
}

/* Filtering array elements */
val myNewArrayFiltered =
  myNewArray.filter(i => i > 4)

/* Filtering and mapping*/
val myNewArrayFilteredAndMapped =
  myNewArray.filter(i => i == 3)
    .map(i => i * 9)
println(myNewArrayFilteredAndMapped.head)

/* --------------------------------*/
/* ------------ Maps --------------*/
/* (analog to Python dictionaries) */

/* create an immutable map as a val */

/* You want to add, update, or delete
elements when working with
an immutable map.
Use the correct operator for each
purpose, remembering to assign
the results to a new map. */
val myMap = Map(
  "firstName" -> "Emma",
  "lastName" -> "Grimaldi",
  "age" -> 18
)
println(myMap)
println(myMap("firstName"))

val myMap_analog = (
  ("firstName", "Emma"),
  ("lastName", "Grimaldi"),
  ("age", 18)
)
println(myMap_analog)

val myNewMap = {
  myMap + ("countryOfOrigin" -> "Italy")
}

/* Looping over maps */

for ((key, value) <- myNewMap) {
  println(key, value)
}

/* Manipulating immutable maps */

val a = Map("A0" -> "B0")
val b = a + ("A1" -> "B1")
val c = b + ("A1" -> "b1")
val d = b + ("A2" -> "B2",
  "A3" -> "B3")
val e = d - "A2"
println(a)
println(b)
println(c)
println(d)
println(e)

/* you can also declare an
immutable map as a var.
Doing so has a dramatic
difference on how you
can treat the map: */
var x = Map("A1" -> "B1")
println(x)
// add elements
x += ("A2" -> "B2"); println(x)
x += ("A3" -> "B3", "A4" -> "B4")
println(x)
// add a tuple to a map
// (replacing the previous "A1" key)
x += ("A1" -> "b1"); println(x)
// remove an element
x -= "A4"; println(x)
x -= ("A1", "A2"); println(x)
/* It’s important to understand that
when you create an immutable map as a
var, you still have an immutable map.
For instance, you can’t reassign an
element in the map. */

/* What’s really happening in the
previous examples is that because x
was defined as a var, it’s being
reassigned during each step in the
process. This is a subtle but
important distinction to understand. */

/* --------------------------------*/
/* ----------- Lists --------------*/
println("List operations:")
println()
val list1 = List(1, 2, 3, 4)
val list2 = List(3, 4)
val list3 = list1 filterNot(i => i > 2)
val list4 = list1 filterNot(i => i == 1)
val list5 = list1 filter(i => i == 1)
val list6 = list1 filterNot(i => i > 2)
val list7 = list1 filterNot list2.contains
val list8 = list1 diff list2

/* --------------------------------*/
/* -------- Indexing tuples -------*/
val myTup = (1, 2, 3)
println(myTup._2)

/* Sets */
val mySet = Set(1, 3, 5, 1)
println(mySet)

/* --------------------------------*/
/* ------ Defining a function -----*/

/* Scala wants to know what
types of variables we are going
to input and output, while Python
doesn’t care.*/

/* simple function that takes a
string as input and returns the
first 5 characters */

def chopString(inputString: String): String = {
  inputString.slice(0, 5)
}

var sampleString = "averylongstring"
val shortString =
  chopString(sampleString)

/* --------------------------------*/
/* --------- DataFrames -----------*/
var df = sc.sqlContext
  .read
  .format("csv")
  .option("header", "true")
  .option("inferSchema", "true")
  .load("train.csv")