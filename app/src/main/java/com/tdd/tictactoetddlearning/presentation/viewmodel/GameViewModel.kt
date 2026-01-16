package com.tdd.tictactoetddlearning.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.tdd.tictactoetddlearning.presentation.state.GameState
import com.tdd.tictactoetddlearning.presentation.state.UIEvent
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlin.collections.get
import kotlin.text.set

class GameViewModel : ViewModel() {

    private val _state = MutableStateFlow(GameState())
    val state = _state.asStateFlow()

    /**
     * On Event which is called bye the view when user tap on board or restart game
     */
    fun onEvent(event: UIEvent) {
        when (event) {
            is UIEvent.OnCellClicked -> handleTap(event.index)
            UIEvent.Restart -> _state.value = GameState()
        }
    }

    /**
     * Handle tap which checks for winning/dra conditions
     */
    private fun handleTap(index: Int) {
        val s = _state.value

        if (s.board[index] != null || s.winner != null) return

        val newBoard = s.board.toMutableList()
        newBoard[index] = s.currentPlayer

        val winner = checkWinner(newBoard)

        _state.value = s.copy(
            board = newBoard,
            currentPlayer = togglePlayer(s.currentPlayer),
            winner = winner,
            isDraw = false
        )
    }

    /**
     * Toggle player X and O
     */
    private fun togglePlayer(c: Char) = if (c == 'X') 'O' else 'X'

    /**
     * Logic to check winner
     */
    private fun checkWinner(board: List<Char?>): Char? {
        val wins = listOf(
            listOf(0,1,2), listOf(3,4,5), listOf(6,7,8), // rows
            listOf(0,3,6), listOf(1,4,7), listOf(2,5,8), // columns
            listOf(0,4,8), listOf(2,4,6)                 // diagonals
        )
        for (w in wins) {
            val (a,b,c) = w
            if (board[a] != null && board[a] == board[b] && board[b] == board[c]) {
                return board[a]
            }
        }
        return null
    }

}