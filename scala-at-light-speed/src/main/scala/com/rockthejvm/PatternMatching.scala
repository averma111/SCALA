package com.rockthejvm

object PatternMatching extends App {

  // swtich expression in other languages
  val aInteger = 56
  val order = aInteger match {
    case 1 => "First"
    case 2 => "Second"
    case 3 => "Third"
    case _ => aInteger+"th"
  }
  println(order)
  // Pattern matching is an expression
  // We can use pattern match to get the individual fields from case class

  case class Person(name:String, age:Int)
    val bob = Person("Bob",56) // Person.apply("Bob",56) // has companion object with apply method
    val personGreeting = bob match {
      case Person(n,a) => s"Hi my name is $n and I am $a years old"
      case _ => "Something else"
    }
  println(personGreeting)

  // decomposing tuples
  val aTuple = ("Ashish","Verma")
  val nameExtraction = aTuple match {
    case (fname,lname) => println(s"My firstname is $fname and my lastname is $lname")
    case _ => println("I am not sure what you are talking about")
  }

  // decomposing lists
  val aList  = List(1,2,3)
  val listDescription = aList match {
    case List(_,2,_) => println("List contains 2 on its second place")
    case _ => "uknown list"
  } // This will not match if list two elements or list has four elements.
  // Pattern matching will try case in sequence matching

}
