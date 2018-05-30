val numFriends = Vector(100, 49, 41, 40, 25 
                        // and lots more
                        )

// function to return the histogram of the input Vector
val counter = (x: Vector[Int]) => x.groupBy(identity).mapValues(_.size)

val friendCounts = counter(numFriends)
val numPoints = numFriends.size
val sortedFriends = numFriends.sortBy(_ > _)

val smallestValue = sortedFriends(0)
val largestValue = sortedFriends(sortedFriends.size - 1)

print("\nob_scala_eol")

val mean = (d: Vector[Int]) => d.sum.toDouble/d.size

val meanFriends = mean(numFriends)

val median = (d: Vector[Int]) => {
  val n = d.size
  val sortedD = d.sortBy(_ > _)
  n.mod(2) match {
    case 0 {(sortedD(n) + sortedD(n-1))/2.0}
    case 1 {sortedD(n)}
  }
}

print("\nob_scala_eol")

val quantile(d: Vector[Int], p: Int) => {
  val ix = p.*(d.size).toInt
  d.sortBy(_ > _)(ix)
}

val mode(d: Vector[Int]) => {
  val counted = d.groupBy(identity).mapValues(_.size)
  val maxCount  = counted.maxBy(_._2)
  counted.filter(_._2 == maxCount).map(_._1)
}

print("\nob_scala_eol")

val dataRange = (x: Vector[Double]) => x.max - x.min

//assert(dataRange(num_friends) == 99)
print("\nob_scala_eol")

val deMean = (x: Vector[Double]) => {
  val meanVal = mean(x)
  return x.map(_ - meanVal)
}

val variance = (x: Vector[Double]) => {
  val deMeanedX = deMean(x)
  sumOfSquares(deMeanedX) / (x.size - 1)
}
//assert(variance(num_friends) == 81.54)
val standardDeviation = (x: Vector[Double]) => Math.sqrt(variance(x))
//assert(standardDeviation(num_friends) == 9.03)

val interquartileRange = (x: Vector[Double]) => quantile(x, 0.75) - quantile(x, 0.25)
//assert(interquartileRange(num_friends) == 6)
print("\nob_scala_eol")
