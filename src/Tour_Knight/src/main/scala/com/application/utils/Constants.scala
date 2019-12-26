package com.application.utils
import com.application.model.Moves

object Constants {
  val INITIAL_VAR_VALUE: Int = -1
  val MATRIX_DIMENSION: Int = 10

  val MOVELIST = List(
    Moves(3, 0),
    Moves(0, 3),
    Moves(-3, 0),
    Moves(0, -3),
    Moves(2, 2),
    Moves(2, -2),
    Moves(-2, 2),
    Moves(-2, -2)
  )
}
