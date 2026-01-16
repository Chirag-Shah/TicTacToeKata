package com.tdd.tictactoetddlearning.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.tdd.tictactoetddlearning.presentation.state.UIEvent
import com.tdd.tictactoetddlearning.presentation.viewmodel.GameViewModel
import com.tdd.tictactoetddlearning.ui.components.BoardGrid

/**
 * This is the Board screen where users tap in the cell and play the game
 */
@Composable
fun BoardScreen(modifier: Modifier, viewModel: GameViewModel = viewModel()) {
    val state by viewModel.state.collectAsState()

    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {

        Text(
            text = when {
                state.winner != null -> "Congratulations ${state.winner}, you are winner"
                state.isDraw -> "Oops, It's Draw!"
                else -> "Turn: ${state.currentPlayer}"
            },
            fontSize = 28.sp,
            modifier = Modifier.padding(16.dp)
        )

        BoardGrid(state) { viewModel.onEvent(UIEvent.OnCellClicked(it)) }

        Spacer(Modifier.height(16.dp))

        Button(onClick = { viewModel.onEvent(UIEvent.Restart) }, colors = ButtonDefaults.buttonColors(
            containerColor = Color.White,
            contentColor = Color.Black
        )) {
            Text("Restart")
        }
    }
}
