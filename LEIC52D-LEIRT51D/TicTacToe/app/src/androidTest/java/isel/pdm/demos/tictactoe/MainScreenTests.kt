package isel.pdm.demos.tictactoe

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import isel.pdm.demos.tictactoe.main.MainScreen
import isel.pdm.demos.tictactoe.main.PlayButtonTag
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test

class MainScreenTests {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun initially_the_start_game_button_is_available() {
        // Arrange
        composeTestRule.setContent {
            MainScreen(onPlayRequested = { })
        }
        // Act
        // Assert
        composeTestRule.onNodeWithTag(PlayButtonTag).assertExists()
    }

    @Test
    fun pressing_the_start_game_button_calls_the_onPlayRequested_callback() {
        // Arrange
        var playRequested = false
        composeTestRule.setContent {
            MainScreen(onPlayRequested = { playRequested = true })
        }
        // Act
        composeTestRule.onNodeWithTag(PlayButtonTag).performClick()
        // Assert
        assertTrue(playRequested)
    }
}
