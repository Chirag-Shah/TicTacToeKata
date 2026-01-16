package com.tdd.tictactoetddlearning

import com.tdd.tictactoetddlearning.presentation.viewmodel.GameViewModel
import org.junit.Before

class GameViewModelTest {

    private lateinit var viewModel: GameViewModel

    @Before
    fun setup() {
        viewModel = GameViewModel()
    }
}