case class Perceptron(var weights: Vector[Double]) {

  //given a feature vector and a set of weights, classify instance
  def classify(features: Vector[Double]): Int = {
    sigNum(dotProduct(features, weights))
  }

  //given data, a learning rate, number of iterations, and initial weights train return final Perceptron
  def train(data: Vector[(Vector[Double], Int)], learningRate : Double = 0.25) = {
    for (d <- data) {
      val error = sigNum(dotProduct(d._1, weights)) - d._2
      weights = (weights zip d._1).map(x => x._1 - learningRate * error * x._2)
      prtWeights()
    }
  }

  private def dotProduct(xs: Vector[Double], ys: Vector[Double]): Double =
    (xs zip ys).map(x => x._1 * x._2).sum

  private def sigNum(activation: Double): Int = {
    activation > 0 match {
      case true => 1
      case false => 0
    }
  }
  
  private def prtWeights(): Unit = printf("w = %f , %f , %f\n", weights(0), weights(1), weights(2))
}