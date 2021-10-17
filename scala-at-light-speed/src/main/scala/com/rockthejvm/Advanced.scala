package com.rockthejvm

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Failure, Success, Try}

object Advanced extends  App {

  // lazy evaluation
  lazy val  aLazyValue = 4
  lazy val aLazyValueWithSideEffect = {
    println("I am not so lazy")
    56
  } // block and last line will acts are return
  val eagerValue = aLazyValueWithSideEffect + 2 // its getting invoked when its used first time
  // they are useful in infinte collections

  //pseudo-collections : Option, Try types
  def methodWhichCanReturnNull(): String = "hello Scala"
  val anOption = Option(methodWhichCanReturnNull()) // Some("hello Scala")
  // option = "collection" which contains at most one element : Some(value) or None
  val stringProcessing  = anOption match {
    case Some(string) => println(s"I have obtained a valid string $string")
    case None => println("I obtained nothing")
  }// Hence we can do null check by simply wrapping the def in Option and create pattern matching on it

  // Using try collections to wrap def which can throw exceptions
  def methodWhichCanThrowExceptions() : String = throw new RuntimeException
  val aTry = Try(methodWhichCanThrowExceptions())
  // a try = collection with either a value if the code went well or an expection if the code thew expections
  val anotherStringProcessing = aTry match {
    case Success(validValue) => s"I have obtained a value $validValue"
    case Failure(ex) => s"I have obtained an expection $ex"
  }

  // Asynchronous Prograaming
  val aFuture = Future{
    println("Loading...")
    Thread.sleep(1000)
    println("I have computed a value ")
    67
  } // Global value is the collection of threads on which we can evaluate of Future expression
  //Meaning println("I have computed a value ") is evaluated on different thread
  Thread.sleep(2000)
  // Future is a "collection" which contains a value when its evaluated
  // Future is composable with map,flatmap, and filter

  /**
   * Implicits Basics
   */
  // 1 Implicits Arguments
  def aMethodWithImplicitArgs(implicit  arg:Int) = arg + 1
  implicit  val myImplicit = 54
  println(aMethodWithImplicitArgs) // this is equivalent aMethodWithImplicitArgs(myImplicit)
  // 2 Implicit Conversion
  implicit class MyRichInteger(number:Int){
    def isEven() = number %2 ==0
  }
  println(34.isEven()) // new MyMyRichInteger(34).isEven()
  // use implicits carefully
}
