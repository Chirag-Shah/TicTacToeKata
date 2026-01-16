package com.tdd.tictactoetddlearning.presentation.state

data class GameState(
    val board: List<Char?> = List(9) { null },
    val currentPlayer: Char = 'X',
    val winner: Char? = null,
    val isDraw: Boolean = false
)