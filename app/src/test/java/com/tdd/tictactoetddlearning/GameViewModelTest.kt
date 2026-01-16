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

    @Test
    fun `test winner X First Row`() {
        viewModel.onEvent(UIEvent.OnCellClicked(0)) // X
        viewModel.onEvent(UIEvent.OnCellClicked(3)) // O
        viewModel.onEvent(UIEvent.OnCellClicked(1)) // X
        viewModel.onEvent(UIEvent.OnCellClicked(4)) // O
        viewModel.onEvent(UIEvent.OnCellClicked(2)) // X

        assertEquals('X', viewModel.state.value.winner)
    }

    @Test
    fun `test winner X Second Row`() {
        viewModel.onEvent(UIEvent.OnCellClicked(3)) // X
        viewModel.onEvent(UIEvent.OnCellClicked(1)) // O
        viewModel.onEvent(UIEvent.OnCellClicked(4)) // X
        viewModel.onEvent(UIEvent.OnCellClicked(8)) // O
        viewModel.onEvent(UIEvent.OnCellClicked(5)) // X

        assertEquals('X', viewModel.state.value.winner)
    }

    @Test
    fun `test winner O Third Row`() {
        viewModel.onEvent(UIEvent.OnCellClicked(1)) // X
        viewModel.onEvent(UIEvent.OnCellClicked(6)) // O
        viewModel.onEvent(UIEvent.OnCellClicked(0)) // X
        viewModel.onEvent(UIEvent.OnCellClicked(7)) // O
        viewModel.onEvent(UIEvent.OnCellClicked(3)) // X
        viewModel.onEvent(UIEvent.OnCellClicked(8)) // O

        assertEquals('O', viewModel.state.value.winner)
    }

    @Test
    fun `test winner X First Column`() {
        viewModel.onEvent(UIEvent.OnCellClicked(0)) // X
        viewModel.onEvent(UIEvent.OnCellClicked(1)) // O
        viewModel.onEvent(UIEvent.OnCellClicked(3)) // X
        viewModel.onEvent(UIEvent.OnCellClicked(8)) // O
        viewModel.onEvent(UIEvent.OnCellClicked(6)) // X

        assertEquals('X', viewModel.state.value.winner)
    }

    @Test
    fun `test winner X Second Column`() {
        viewModel.onEvent(UIEvent.OnCellClicked(1)) // X
        viewModel.onEvent(UIEvent.OnCellClicked(5)) // O
        viewModel.onEvent(UIEvent.OnCellClicked(4)) // X
        viewModel.onEvent(UIEvent.OnCellClicked(2)) // O
        viewModel.onEvent(UIEvent.OnCellClicked(7)) // X

        assertEquals('X', viewModel.state.value.winner)
    }

    @Test
    fun `test winner O Third Column`() {
        viewModel.onEvent(UIEvent.OnCellClicked(0)) // X
        viewModel.onEvent(UIEvent.OnCellClicked(2)) // O
        viewModel.onEvent(UIEvent.OnCellClicked(1)) // X
        viewModel.onEvent(UIEvent.OnCellClicked(5)) // O
        viewModel.onEvent(UIEvent.OnCellClicked(7)) // X
        viewModel.onEvent(UIEvent.OnCellClicked(8)) // O

        assertEquals('O', viewModel.state.value.winner)
    }
}