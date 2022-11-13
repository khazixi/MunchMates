package com.example.myapplication.ui.components

import androidx.compose.material.BottomAppBar
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.myapplication.R

// TODO: Extract into components file
@Composable
fun NavBar(
    settingsListener: () -> Unit,
    scheduleListener: () -> Unit,
    homeListener: () -> Unit,
    modifier: Modifier = Modifier
) {
    BottomAppBar(
    ) {
        IconButton(
            onClick = settingsListener,
            modifier = modifier
        ) {
            Icon(
                painter = painterResource(
                    id = R.drawable.ic_baseline_settings_24
                ),
                contentDescription = "Settings"
            )
        }
        IconButton(
            onClick = scheduleListener,
            modifier = modifier
        ) {
            Icon(
                painter = painterResource(
                    id = R.drawable.ic_baseline_schedule_24
                ),
                contentDescription = "Schedule"
            )
        }

        IconButton(onClick = homeListener) {
            Icon(
                painter = painterResource(
                id = R.drawable.ic_baseline_home_24
            ),
                contentDescription = "Home"
            )
        }

    }
}
