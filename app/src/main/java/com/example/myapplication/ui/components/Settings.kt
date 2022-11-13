package com.example.myapplication.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun SettingsBody(
    homeListener: () -> Unit = {},
    settingsListener: () -> Unit = {},
    scheduleListener: () -> Unit = {}
)
 {
    Scaffold(
        bottomBar = {
            NavBar(
                homeListener = homeListener,
                settingsListener = settingsListener,
                scheduleListener = scheduleListener
            )
        },
        content = {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
            ) {
                Text(text = "Sample Text for Settings Page")
            }
        }
    )
}