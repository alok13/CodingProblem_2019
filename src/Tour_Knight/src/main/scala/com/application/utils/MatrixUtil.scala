package com.application.utils
import com.application.model.Moves

object MatrixUtil {

  def displayMatrix(visited: Array[Int], dimension: Int): Unit = {
    for (i <- 0 until dimension) {
      for (j <- 0 until dimension) {
        print(" " + visited(j * dimension + i) + " ")
      }
      println()

    }
  }

  def getDegree(visited: Array[Int],
                xCoordinate: Int,
                yCoordinate: Int,
                moveList: List[Moves],
                dimension: Int): Int = {

    var count = 0
    for (i <- moveList.indices) {
      val empty = isEmpty(
        visited,
        xCoordinate + moveList(i).x,
        yCoordinate + moveList(i).y,
        dimension
      )
      if (empty)
        count += 1
    }

    count
  }

  def isEmpty(visited: Array[Int],
              xCoordinate: Int,
              yCoordinate: Int,
              dimension: Int): Boolean = {
    limits(xCoordinate, yCoordinate, dimension: Int) && (visited(
      yCoordinate * dimension + xCoordinate
    ) < 0)
  }

  def limits(x: Int, y: Int, dimension: Int): Boolean =
    (x >= 0 && y >= 0) && (x < dimension && y < dimension)
}
