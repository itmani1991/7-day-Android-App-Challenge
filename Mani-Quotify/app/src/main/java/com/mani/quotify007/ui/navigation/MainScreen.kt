package com.mani.quotify007.ui.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.mani.quotify007.ui.navigation.model.MainEvent
import com.mani.quotify007.ui.navigation.model.MainState
import com.mani.quotify007.ui.screens.bottomappbar.BottomAppBar
import com.mani.quotify007.ui.theme.QuotifyAppTheme

@Composable
fun MainScreen(
    state: MainState,
    onEvent: (MainEvent) -> Unit
) {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomAppBar(navController) }
    ) { innerPadding ->
        Box {
            if (state.isLoading) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
            NavigationGraph(
                navController = navController,
                modifier = Modifier.padding(innerPadding),
                state = state,
                onEvent = onEvent
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    QuotifyAppTheme {
        MainScreen(
            state = MainState(),
            onEvent = {}
        )
    }
}