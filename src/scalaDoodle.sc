/* print greeting */
println("Hello, New Amsterdam!")

/* ------------------------------------------- */
/* --------- Variables and values ------------ */
/* ------------------------------------------- */

/* add a variable */
var string = "myString"
println(string)
string = "myNewString"
println(string)

/* add a constant */
val const_string = "myNeverChangingString"
println(const_string)
/* this command will throw an error - can't change value of a val
const_string = "andNowIWantToChangeIt" */

/* ------------------------------------------- */
/* --------------- Arrays -------------------- */
/* ------------------------------------------- */

var myArray = Array(2, 5, "apple", 78)
println(myArray)

/* arrays are zero indexed, which means that the first element is
placed at the index 0. So, if we want to extract the third element: */

println(myArray(2))

/* the second index will not be counted when slicing.
So, if we want to extract the first 3 elements:*/
println(myArray.slice(0, 3))

var myNewArray = Array(1, 2, 3, 4, 5)

println(myNewArray.head) // first element
println(myNewArray(0)) // other way to check the first element
println(myNewArray.last) // last element
println(myNewArray.max) // maximum element
println(myNewArray.min) // minimum element

/* NOTE: .min and .max will work exclusively if the array contains numbers only! */

/* ------------------------------------------- */
/* ------------- Sum and product ------------- */
/* ------------------------------------------- */

println(myNewArray.sum) // summing elements in array
println(myNewArray.product) // multiplying elements in array

/* ------------------------------------------- */
/* ------- Add new element to an array ------- */
/* ------------------------------------------- */

/* Lists and arrays are not ordered, so it’s common practice to add elements at the end.
Let’s say we want to add the string "last words": */

//  myNewArray :+= "last words" // adding at the end of Scala array

/* This will throw an error, because MyNewArray is an array of type Int: */

// [error] C:\Users\Administrator\Documents\tmpScala\hello-world\src\main\scala\Main.scala:88:14: value :+= is not a member
// of Array[Int]
// [error]   Expression does not convert to assignment because:
// [error]     type mismatch;
// [error]      found   : Array[Any]
// [error]      required: Array[Int]

/* Adding new value at the end of a mixed type array (this will work) */

myArray :+= "last words"
println(myArray.last)

/* Adding new value at the beginning of an array */
myNewArray +:= 999999
println(myNewArray(0))

/* ------------------------------------------- */
/* ---------------- For loops ---------------- */
/* ------------------------------------------- */

/* Scala wants the for conditions in parenthesis, and the block
in curly brackets, with no indentation needed
(but can still be used to make the code more readable */

println("------ Looping over myArray ------")
var iteration = 0
println("Loop Start: Iteration:", iteration)
for (i <- myArray) {
  iteration += 1
  println("Iteration:", iteration)
  println(i)
}

println("----- Looping over myNewArray -----")
iteration = 0
println("Loop Start:", iteration)
for (i <- myNewArray) {
  iteration += 1
  println("Iteration:", iteration)
  println(i)
}

/* ------------------------------------------- */
/* ----------------- Mapping ----------------- */
/* ------------------------------------------- */

/* Let’s say we have a list/array with only numeric
values and we want to triple all of them. */

var myNewArrayTripled = myNewArray.map(i => i * 3) // mapping in Scala

/* print all elements of myNewArrayTripled */
iteration = 0
println("myNewArrayTripled:")
for (i <- myNewArrayTripled) {
  iteration += 1
  println(iteration, i)
}


/* -------------------------------------------- */
/* ---------------- Filtering ----------------- */
/* -------------------------------------------- */

/* Let’s say we have a list/array with only numeric
values and we want to filter only those divisible by 3. */

var myNewArrayFiltered = myNewArray.filter(i => i % 3 == 0) // filtering in Scala
/* print all elements of myNewArrayFiltered */
iteration = 0
println("myNewArrayFiltered:")
for (i <- myNewArrayFiltered) {
  iteration += 1
  println(iteration, i)
}

/* -------------------------------------------- */
/* --------- Filtering and mapping ------------ */
/* -------------------------------------------- */

/* What if we want to find the even numbers and multiply only them by 3? */
var myNewestArray = myNewArray.filter(i => i % 2 == 0).map(i => i * 3)
iteration = 0
println("myNewestArray (myNewArray filtered for even nums and multiplied by 3:")
for (i <- myNewestArray) {
  iteration += 1
  println(iteration, i)
}

/* -------------------------------------------- */
/* ---------- Dictionaries / Maps ------------- */
/* -------------------------------------------- */

/* ------------- Creating a Map --------------- */

/* Although they have different names in Python and Scala, they are
exactly the same thing. They both have keys to which we assign values. */

/* In Scala, we can create an immutable map in two different ways. */

// Scala mode 1
val myMap1 = Map(
  "firstName" -> "Emma",
  "lastName" -> "Grimaldi",
  "age" -> 18
)

println(myMap1)

// Scala mode 2
val myMap2 = (
  ("firstName", "Emma"),
  ("lastName", "Grimaldi",
    ("age", 18))
)
println(myMap2)

/* ------ Adding a new element to a Map ------- */

/* Let’s add my Country of origin to my dictionary/map. */
val myNewMap1 = {
  myMap1 + ("countryOfOrigin" -> "Italy")
}
println(myNewMap1)

val a = Map("AL" -> "Alabama")
// add one element
val b = a + ("AK" -> "Alaska")
// add multiple elements
val c = b + ("AR" -> "Arkansas", "AZ" -> "Arizona")
println(a)
println(b)
println(c)

/* ------ Updating an element in a Map- ------- */

/* To update a key/value pair with an immutable map,
reassign the key and value while using the + method,
and the new values replace the old:  */

val d = c + ("AR" -> "banana")

/* ------ Removing elements from a Map- ------- */

/* To remove one element, use the - method: */
val e = d - "AR"
println(e)

val list1 = List(1,2,3,4)
val list2 = List(2,3)

val list3 = list1 filterNot list2.contains
println("List 1")
for (i <- list1) {
  println(i)
}
println("List 2")
for (i <- list2) {
  println(i)
}
println("List 1 without List 2")
for (i <- list3) {
  println(i)
}

/* the same can be accomplished using */
val list4 =  List(1,2,3,4) diff List(1,2)
for (i <- list4) {
  println(i)
}