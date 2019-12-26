package com.application
import com.application.model.{Moves, Square}
import com.application.utils.{Constants, MatrixUtil}

class TourApplication(startX: Int = 0, startY: Int = 0) {

  def findTour: Boolean = {
    val visited =
      new Array[Int](Constants.MATRIX_DIMENSION * Constants.MATRIX_DIMENSION)
    for (i <- visited.indices)
      visited.update(i, -1)

    val starting_Square = Square(startX, startY)
    visited.update(startX * Constants.MATRIX_DIMENSION + startY, 1)

    for (i <- 0 until Constants.MATRIX_DIMENSION * Constants.MATRIX_DIMENSION) {
      if (nextMove(visited, starting_Square) == null)
        false
    }
    if (!hasTourEnded(
          starting_Square.xCoordinate,
          starting_Square.yCoordinate,
          startX,
          startY
        ))
      return false

    MatrixUtil.displayMatrix(visited, Constants.MATRIX_DIMENSION)
    true
  }

  def getDegree(visited: Array[Int],
                xCoordinate: Int,
                yCoordinate: Int): Int = {

    var count = 0
    for (i <- Constants.MOVELIST.indices) {
      if (isEmpty(
            visited,
            xCoordinate + Constants.MOVELIST(i).x,
            yCoordinate + Constants.MOVELIST(i).y
          ))
        count += 1
    }
    count
  }

  def isInLimits(x: Int, y: Int): Boolean =
    (x >= 0 && y >= 0) && (x < Constants.MATRIX_DIMENSION && y < Constants.MATRIX_DIMENSION)

  def isEmpty(visited: Array[Int],
              xCoordinate: Int,
              yCoordinate: Int): Boolean = {
    isInLimits(xCoordinate, yCoordinate) && (visited(
      yCoordinate * Constants.MATRIX_DIMENSION + xCoordinate
    ) < 0)
  }

  def nextMove(visited: Array[Int], square: Square): Square = {
    var degree_index = Constants.INITIAL_VAR_VALUE
    var minimum_degree = Constants.MATRIX_DIMENSION + 1
    var new_xCoordinate = Constants.INITIAL_VAR_VALUE
    var new_yCoordinate = Constants.INITIAL_VAR_VALUE
    var degree = Constants.INITIAL_VAR_VALUE

    val start = scala.util.Random.nextInt(Constants.MATRIX_DIMENSION)
    val moveOptions = Constants.MOVELIST.size
    for (i <- 0 to moveOptions) {
      val index = (start + i) % moveOptions
      new_xCoordinate = square.xCoordinate + Constants.MOVELIST(index).x
      new_yCoordinate = square.yCoordinate + Constants.MOVELIST(index).y
      degree = getDegree(visited, new_xCoordinate, new_yCoordinate)
      if (isEmpty(visited, new_xCoordinate, new_yCoordinate) && degree < minimum_degree) {
        degree_index = index
        minimum_degree = degree
      }
    }

    if (degree_index == -1)
      return null

    def updateNewSquare = {
      new_xCoordinate = square.xCoordinate + Constants.MOVELIST(degree_index).x
      new_yCoordinate = square.yCoordinate + Constants.MOVELIST(degree_index).y

      visited.update(
        new_yCoordinate * Constants.MATRIX_DIMENSION + new_xCoordinate,
        visited(
          square.yCoordinate * Constants.MATRIX_DIMENSION + square.xCoordinate
        ) + 1
      )

      square.xCoordinate = new_xCoordinate
      square.yCoordinate = new_yCoordinate
      square
    }
    updateNewSquare

  }

  def hasTourEnded(xCoordinate: Integer,
                   yCoordinate: Integer,
                   startX: Int,
                   startY: Int): Boolean = {
    for (i <- Constants.MOVELIST.indices)
      if (((xCoordinate + Constants.MOVELIST(i).x) == startX) &&
          ((yCoordinate + Constants.MOVELIST(i).y) == startY))
        return true

    false
  }

}
