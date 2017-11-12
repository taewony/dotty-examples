
object Main {
  def msg = "taewony"
  def main(args: Array[String]): Unit = {

    if (args.size < 2) {
      println("Hello Perceptron!")
    }
    else {
      val w = Vector(-0.05,-0.02,0.02)
      val p = Perceptron(w)
      val x = Vector(-1.0, args(0).toDouble, args(1).toDouble)
      
      val y = p.classify(x)
      println("result = " + y)
      
      for(i <- 1 to 1) {
        val v = Vector((Vector(-1.0,0.0,0.0),0),(Vector(-1.0,0.0,1.0),1),(Vector(-1.0,1.0,0.0),1),(Vector(-1.0,1.0,1.0),1))
        p.train(v)
        p.whoami
        //val y = p.classify(x)
        //println(i + "result = " + y)
      }
    }
  }
  /*
  def main(args: Array[String]): Unit = {

    runExample("Trait Params")(TraitParams.test)

    runExample("Enum Types")(EnumTypes.test)

    runExample("Implicit Functions")(ImplicitFunctions.test)

    runExample("Implicit Params")(ImplicitParams.test)

    runExample("Implicit Conversion")(ImplicitConversion.test)

    runExample("Union Types")(UnionTypes.test)

    runExample("Intersection Types")(IntersectionTypes.test)

    runExample("Type Lambda")(TypeLambdas.test)

    runExample("Multiversal Equality")(MultiversalEquality.test)

    runExample("Named Type Arguments")(NamedTypeArguments.test)

    runExample("Auto Param Tupling")(AutoParamTupling.test)

    runExample("Structural Types")(StructuralTypes.test)

    runExample("Pattern Matching")(PatternMatching.test)

  }

  private def runExample(name: String)(f: => Unit) = {
    println(Console.MAGENTA + s"$name example:" + Console.RESET)
    f
    println()
  }
  */
}
