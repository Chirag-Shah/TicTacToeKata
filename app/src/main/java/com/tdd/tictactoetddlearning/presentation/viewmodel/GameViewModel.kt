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
            UIEvent.Restart -> { //To-Do
            }
        }
    }

    /**
     * Handle tap which checks for winning/dra conditions
     */
    private fun handleTap(index: Int) {
        val s = _state.value

        val newBoard = s.board.toMutableList()
        newBoard[index] = s.currentPlayer

        _state.value = s.copy(
            board = newBoard,
            currentPlayer = togglePlayer(s.currentPlayer),
            winner = null,
            isDraw = false
        )
    }

    /**
     * Toggle player X and O
     */
    private fun togglePlayer(c: Char) = if (c == 'X') 'O' else 'X'
}