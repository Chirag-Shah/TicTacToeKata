package com.tdd.tictactoetddlearning

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.tdd.tictactoetddlearning.ui.screen.BoardScreen
import com.tdd.tictactoetddlearning.ui.theme.TicTacToeTDDLearningTheme

/**
 * Starting activity of our Tic-Tac-Toe game
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TicTacToeTDDLearningTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BoardScreen(Modifier.padding(innerPadding))
                }
            }
        }
    }
}
