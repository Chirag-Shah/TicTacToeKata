package com.tdd.tictactoetddlearning.presentation.state

/**
 * UI events that transferred from UI to board
 */
sealed class UIEvent {
    data class OnCellClicked(val index: Int) : UIEvent()
    object Restart : UIEvent()
}