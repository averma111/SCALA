package com.rockthejvm

import java.security.KeyStore.TrustedCertificateEntry

object ObjectOrientation extends  App{

  // class and instance
  class Animal {
    // define fields
    val age = 0
    // define methods
    def eat() = println("I am eating")
  }

  val animal = new Animal
  // inheritance
  class Dog(val name: String) extends Animal  //constructor definition
   val aDog = new Dog("Sky")

  // constructor arguements are not fields: need to put a val before the constructor argument
  aDog.name

  // subtype polymorphism
  val aDeclarationAnimal: Animal = new Dog("Tommy")
  aDeclarationAnimal.eat() // the mode derived method will be called at runtime

  // abstract class
  abstract  class WalkingAnimal {
    val hasLegs =  true // by default public, cab be restricted by private of protected
    def walks(): Unit
  }

  // interface = utlimate abstract type
  trait Carnivore {
    def eat(animal : Animal): Unit
  }

  trait Philosopher{
    def ?!(thought:String):Unit
  }
  // We can extend single class but multiple traits ==="mixing"
  class Crocodile extends  Animal with Carnivore with Philosopher {
    override def eat(animal: Animal): Unit = println("I am eating you animal")
    override  def ?!(thought:String):Unit = println(s"I was thinking $thought")
  }
  val aCroc = new Crocodile
  aCroc.eat(aDog)
  aCroc eat aDog // infix Notation = object methode argument , only available for methos with one arguments
  aCroc ?! "What if we could fly?"

  // operators in Scala are actually methods
  val basicMaths = 1.+(2)

  //Anonymous classes
  val dianasour = new Carnivore {
    override def eat(animal: Animal): Unit = println("I am diansour so I can eat pretty much anything")
  }
  /*
  What I have told above to Scala compiler
    class Carnivor_2345_temp extends Carnivor{
    override def eat(animal: Animal): Unit = println("I am diansour so I can eat pretty much anything")
     val dianasour = new Carnivore_2345_temp
    }
   */
  // Singleton Object
  object mySingletonObject { // the only instance of mySingleton type
  val mySpecialValue = 4567
    def mySpecialMethod():Int = 4567
    def apply(x:Int):Int = x + 1
  }
  mySingletonObject.mySpecialMethod()
  mySingletonObject.apply(56)
  mySingletonObject(56)//equivalent to line 72 to call apply method

  object Animal { // companions - companion object
  // companion can access each other's private fields or methods
    // singleton Animal and instances of Animal are different things
    val canLiveIndefinitly = false

  }
  val animalCanLiveForever = Animal.canLiveIndefinitly // equivalent to "static" in java

  /*
  case classes = lightweight data structures with some boilerplate
   */
  case class Person(name: String, age:Int){
    // sensible equal and hash code
    // serialization
    // companion with apply method
    // pattern matching

    val bob = new Person("Arjun", 2)
    val bob1 = Person("bob",56) // equivalent to line 92
  }
  // Exceptions
  try {
    val x:String = null
    x.length
  } catch {
    case e : Exception => "Some faulty message"
  } finally {
    // Executed no matter what is result of try and catch
  }

  // generics
  abstract class Mylist[T]{
    def head:T
    def tail: Mylist[T]
  }
  // using a generic with concrete type
  val aList: List[Int] = List(1,2,4) // List.apply(1,2,4)
  val first = aList.head
  val rest = aList.tail
  val aStringList = List("Hello","Scala")
  val firstString = aStringList.head // String now
  val restString = aStringList.tail

  // Point 1: In scala we operate with mostly Immutable values
  // Any modification to a object must return Another object
  /*
   Benefits
   works mirable in multi threading environments
   helps making sense of code  ("reasoning about")
   */
  val reverseList = aList.reverse // returns  new list

  // Point 2: Scala is closet to OO ideal
}
