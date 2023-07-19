package com.example.artspace

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.example.artspace.ui.theme.ArtSpaceTheme
import org.junit.Rule
import org.junit.Test

// Referred to as instrumentation tests

class UITests {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun nextClicked() {
        composeTestRule.setContent {
            ArtSpaceTheme {
                ArtSpace()
            }
        }

        composeTestRule.onNodeWithText("Next").performClick()
        composeTestRule.onNodeWithText("Painting").assertExists("Node does not exist")
    }


}