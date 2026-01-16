package com.tdd.tictactoetddlearning

import com.tdd.tictactoetddlearning.presentation.state.UIEvent
import com.tdd.tictactoetddlearning.presentation.viewmodel.GameViewModel
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test
import kotlin.collections.get

class GameViewModelTest {

    private lateinit var viewModel: GameViewModel

    @Before
    fun setup() {
        viewModel = GameViewModel()
    }

    @Test
    fun `test X moves first`() {
        viewModel.onEvent(UIEvent.OnCellClicked(0))
        assertEquals('X', viewModel.state.value.board[0])
    }

    @Test
    fun `test player toggles after move`() {
        viewModel.onEvent(UIEvent.OnCellClicked(0))
        assertEquals('O', viewModel.state.value.currentPlayer)
    }

    @Test
    fun `test restart match`() {
        viewModel.onEvent(UIEvent.OnCellClicked(0))
        viewModel.onEvent(UIEvent.Restart)
        assertEquals(null, viewModel.state.value.board[0])
    }
}