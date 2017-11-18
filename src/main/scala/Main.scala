object Main {
  def myName = "taewony"
  def main(args: Array[String]): Unit = {
    val p = Perceptron(Vector(-0.05,-0.02,0.04))
    println("before result(0,0) = " + p.classify(Vector(-1.0, 0.0, 0.0)))
    
    for(i <- 1 to 5) {
      p.train(Vector((Vector(-1.0,0.0,0.0),0),(Vector(-1.0,0.0,1.0),1),(Vector(-1.0,1.0,0.0),1),(Vector(-1.0,1.0,1.0),1)))
    }
    println("after result(0,0) = " + p.classify(Vector(-1.0, 0.0, 0.0)))
    println("after result(1,0) = " + p.classify(Vector(-1.0, 1.0, 0.0)))
    println("after result(0,1) = " + p.classify(Vector(-1.0, 0.0, 1.0)))
    println("after result(1,1) = " + p.classify(Vector(-1.0, 1.0, 1.0)))
  }
}