package com.rockthejvm

object FunctionalProgramming extends  App{
  // Scala is Object Oriented

  class Person(name:String){
    def apply(age:Int): Unit = println(s"I have aged $age years")
  }
  val bob = new Person("Bov")
  bob.apply(56)
  bob(56) //Invoking bob as fucntion === bob.apply(56)

  /*
  Scala runs on JVM which was originally meant for object oriented programming not functional programming
  Functional programming meaning:
  -- compose functions
  -- pass functions as args
  -- return functions as results
  Conclusion : Functions_x === Function1, Function2...Function22(maximum limit of arguments)
   */

  val simpleIncrementer = new Function1[Int,Int] {
    override  def apply (arg:Int ):Int = arg +1
  }
  // All the functions in Scala are the instances of Function_x trait
  simpleIncrementer.apply(45)
  simpleIncrementer(45)
  // define a functions

  // ALL SCALA FUNCTIONS ARE INSTANCES OF THESE FUNCTION_X TYPE

  // Function with 2 arguments and a string return Type
  val stringConcatenate = new Function2[String, String, String]{
    override def apply(arg1: String,arg2: String): String = arg1 + arg2
  }
  stringConcatenate("I love","Abha") // "I love Abha"

  // syntax sugar
  val doubler : Int =>Int =(x:Int) => 2 * x
  /*
  The above is equivalent to below and is good for much larger code base
  val doublre: Function3[Int,Int] = new Function2[Int, Int]{
  override def apply(x:Int) = 2 * x
  }
   */

  // Higher order functions : takes functions as argument or return fucntions as result
  val aMappedList : List[Int] = List(1,2,3).map(x =>x + 1) // map here is higher order functions
  //println(aMappedList)

  val aFlatMappedlist = List(3,4,5).flatMap(x => List(x, 2*x))
  //println(aFlatMappedlist)

  val aFlatMappedListNew = List(4,5,7).flatMap { x=>
    List(x , 3 *x)
  }// alternative syntax for above

  val aFilteredList = List(3,5,6,7,8).filter(x => x >=5)
  //println(aFilteredList)

  // short hand notation
 val aFilterList = List(1,2,3).filter(_ <=3)
  //println(aFilterList)

  // Getting all the pairs of List(1,2,3) and List("a","b","c)
  val allPairs = List(1,2,3).flatMap(number =>List("a","b","c").map(letters => s"$number,$letters"))
  println(allPairs)

  // for comprehension
  val alternativePairs = for {
    number <- List(1,2,3)
    letter <- List('a','b','c')
  }yield s"$number,$letter"  // here for is an expression not for loop
  // allPairs and alternativePairs all same

  /*
  Collections in Scala
   */

  //List
  val aList = List(1,2,4)
  val firstElement = aList.head
  val restElement = aList.tail
  val aPrePendedList = 0::aList //(0,1,2,4)
  val extenddedList = 0 +:aList :+ 6 // (0,1,2,4,6)

  //Sequence
  val aSeq : Seq[Int] = Seq(1,2,3) // Seq.apply(1,2,3) // have companion object and def apply method
  val accessedElement = aSeq(2) // aSeq.apply(2) // access the element at that postion 3

  //Vectors // fast implementation of Sequeces
  val aVecrot  = Vector(1,2,3)

  //Sets have no duplicates
  val aSet = Set(1,2,4,5,1,2)
  val setHas = aSet.contains(4) // This will return true
  val anAddedELement = aSet + 7 // + is used to add elements in set (1,2,4,5,7)
  val removedElement = aSet - 1 // - is used to remove element in set (2,4,5,7)

  // Ranges
  val aRange = 1 to 1000
  val twoByTwo = aRange.map(x => x * 2).toList // List(2,4,6,8....2000)
  //println(twoByTwo)

  val twoByTwoAnotherWay = aRange.map(_ * 2).toList //Shorthand notation
  //print(twoByTwoAnotherWay)

  //tuples == group of values undersame name
  val aTuple = ("Ashish","Verma",510645432)

  // maps ==dictionary in Python
  val aPhoneBook : Map[String, Int] = Map(
    ("Ashish",1234),
    "Verma" ->45566 // equivalent to ("Verma",45566)
  )
}

