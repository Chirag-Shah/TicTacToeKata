package com.tdd.tictactoetddlearning.presentation.state

sealed class UIEvent {
    data class OnCellClicked(val index: Int) : UIEvent()
    object Restart : UIEvent()
}