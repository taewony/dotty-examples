case class Perceptron(var weights: Vector[Double]) {

  def whoami = printf("w = %f , %f , %f\n", weights(0), weights(1), weights(2))

  //given a feature vector and a set of weights, classify instance
  def classify(features: Vector[Double]): Int = {
    sigNum(dotProduct(features, weights))
  }

  //given data, a learning rate, number of iterations, and initial weights train return final Perceptron
  def train(data: Vector[(Vector[Double], Int)], learningRate : Double = 0.25) = {
    weights = trainingCycle(data, learningRate, data.size, weights)
  }

  //represents a full training cycle of n iterations
  // @tailrec
  private def trainingCycle(data: Vector[(Vector[Double], Int)], learningRate: Double, iterRem: Int, weights: Vector[Double]): Vector[Double] = {
    println("reamained iteration: " + iterRem + "w: " + weights)
    iterRem match {
      case 0 => weights
      case _ => trainingCycle(data, learningRate, iterRem - 1, epoch(data, learningRate, weights))
    }
  }

  //represents a full epoch or iteration through all given instances
  // @tailrec
  private def epoch(instances: Vector[(Vector[Double], Int)], learningRate: Double, weights: Vector[Double] ): Vector[Double] = {
    instances match {
      case IndexedSeq() => weights
      case _ => epoch(instances.tail, learningRate, weightGradient(instances.head._1, instances.head._2.toInt, weights, learningRate ))
    }
  }

  private def weightGradient(arguments: Vector[Double], target: Int, weights: Vector[Double], learningRate: Double) = {
    (weights zip arguments).map(x => x._1 - learningRate * (x._2 - target))
  }

  private def dotProduct(xs: Vector[Double], ys: Vector[Double]): Double = {
    (xs zip ys).map(x => x._1 * x._2).sum
  }

  private def sigNum(activation: Double): Int = {
    activation > 0 match {
      case true => 1
      case false => 0
    }
  }
}