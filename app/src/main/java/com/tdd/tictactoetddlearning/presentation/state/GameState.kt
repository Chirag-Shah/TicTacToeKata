package com.tdd.tictactoetddlearning.presentation.state

/**
 * Data class that holds the current state of the board, current player, win/draw state
 */
data class GameState(
    val board: List<Char?> = List(9) { null },
    val currentPlayer: Char = 'X',
    val winner: Char? = null,
    val isDraw: Boolean = false
)