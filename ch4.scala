val heightWeightAge = Vector(70, // inches
                            170, // pounds
                            40) // years

val grades = Vector(95, // exam1
                   80, // exam2
                   75, // exam3
                   62) // exam4

val vectorAdd = (v: Vector[Double], w: Vector[Double]) => {
  v.zip(w).map{x: (Double, Double) => x._1 + x._2}
}

val vectorSubtract = (v: Vector[Double], w: Vector[Double]) => {
  v.zip(w).map{x: (Double, Double) => x._1 - x._2}
}

val vectorSum = (vv: Vector[Vector[Double]]) => {
  vv.reduceLeft(vectorAdd(_, _)) // abstracting away the declaration of intermediate state
}

/** Returns the elements of v multiplied by c
  * v is a vector, c is a scalar
  */
val scalarMultiply = (c: Double, v: Vector[Double]) => {
  v.map(_ * c) // look at that concise expression of a powerful idea
}

/** Returns a vector consisting of the element-wise means of the input vectors
  */
val vectorMean = (vv: Vector[Vector[Double]]) => {
  val n = vv.size
  scalarMultiply(1.0/n, vectorSum(vv))
}

/** Returns the dot product of two vectors
*/
val dotProduct = (v: Vector[Double], w: Vector[Double]) => {
  v.zip(w).map{vw: (Double, Double) => vw._1 * vw._2}.sum
}

print("\nob_scala_eol")

val vectors = (Vector(3.0, 4.0), Vector(3.0, 4.0))
val vectorsRotated = (Vector(5.0, 0.0), Vector(5.0, 0.0))
// I caught a flash of the pythagorean theorem in my head as I typed this

assert(
  dotProduct(vectors._1, vectors._2) == 
  dotProduct(vectorsRotated._1, vectorsRotated._2)
)

print("\nob_scala_eol")

val sumOfSquares = (v: Vector[Double]) => {dotProduct(v,v)}
val magnitude = (v: Vector[Double]) => {Math.sqrt(sumOfSquares(v))}
// and now we're extending the pythagorean theorem into an arbitrary number of dimensions

val squaredDistance = (v: Vector[Double], w: Vector[Double]) => {
  sumOfSquares(vectorSubtract(v,w))
}

val distance = (v: Vector[Double], w: Vector[Double]) => {
  Math.sqrt(squaredDistance)
}

print("\nob_scala_eol")

val A = Vector(Vector(1.0, 2.0, 3.0), // 2 rows, 3 columns
               Vector(4.0, 5.0, 6.0))

val B = Vector(Vector(1.0, 2.0), // 3 rows, 2 columns
               Vector(3.0, 4.0),
               Vector(5.0, 6.0))

print("\nob_scala_eol")

val shape = (A: Vector[Vector[Double]]) => {
  val n = A.size
  val k = A(0).size
  (n, k)
}

print("\nob_scala_eol")

val getRow = (A: Vector[Vector[Double]], i: Int) => A(i)
val getCol = (A: Vector[Vector[Double]], i: Int) => A.map(_(i))
/* Returns a n x k matrix (nested Vectors) whose (i, j)th element is entryFunc(i, j)
 */
val makeMatrix = (n: Int, k: Int, entryFunc: (Int, Int) => Double) => {
  val is = 0 until n
  val js = 0 until k
  is.map{i =>
    js.map{j =>
     entryFunc(i, j)
       }.toVector
  }.toVector
}
  
val isDiagonal = (i: Int, j: Int) => if (i == j) 1.0 else 0.0

}


print("\nob_scala_eol")
