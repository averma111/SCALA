package com.rockthejvm

object Basics extends App {
  // defining a value
  val valueOfLife: Int = 34
  val aBoolean = true // type is optional

  // string and string operations
  val aString = "I love Scala"
  val aComposedString = "I" + " " + "love" + " " + "Scala"
  val anInterpolatedString = s"The meaning of life $valueOfLife"

  // expression = structures that can be reduced to a value
  val anExpression = 2 + 3

  // if-expression
  val ifExpression = if (valueOfLife > 35) 56 else 99
  // chained expression
  val chainedExpression = if (valueOfLife > 35) 56
  else if (valueOfLife < 0) -2
  else if (valueOfLife > 9) 78
  else 0

  // code-blocks
  val aCodeBlock = {
    // definitions
    val aLocalValue = 54
    aLocalValue + 3
  }

  // defining a functions
  def myFunction(x: Int, y: Int): String = x + " " + y

  // or defining a code block
  def myFunction1(x: Int, y: Int): String = {
    x + " " + y
  }
  // recursive function
  def factorial(n:Int) :Int ={
    if (n<=1) 1
    else n * factorial(n - 1)
  }
  // In scala we don't use loops or iterations we use RECURSIONS!

  // the Unit type  = no meaningful value === "void" in other languages
  // as Side effects
  println("I love Scala")

  def myUnitReturningFunction(): Unit ={
    println("I don't love returning Unit")
  }
  val aUnitValue = ()
}
