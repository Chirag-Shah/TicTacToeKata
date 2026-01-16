package com.tdd.tictactoetddlearning.ui.components


import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import com.tdd.tictactoetddlearning.presentation.state.GameState


@Composable
fun BoardGrid(state: GameState, onCellClick: (Int) -> Unit) {
    LazyVerticalGrid(columns = GridCells.Fixed(3)) {
        items(9) { i ->
            BoardCell(value = state.board[i]) { onCellClick(i) }
        }
    }
}
