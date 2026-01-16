package com.tdd.tictactoetddlearning.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.tdd.tictactoetddlearning.presentation.state.GameState
import com.tdd.tictactoetddlearning.presentation.state.UIEvent
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class GameViewModel : ViewModel() {

    private val _state = MutableStateFlow(GameState())
    val state = _state.asStateFlow()

    /**
     * On Event which is called bye the view when user tap on board or restart game
     */
    fun onEvent(event: UIEvent) {
       //To-Do
    }

}