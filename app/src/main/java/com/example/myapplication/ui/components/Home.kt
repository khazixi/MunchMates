package com.example.myapplication.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import java.util.EventListener

@Composable
fun HomepageBody(
    modifier: Modifier = Modifier,
    settingsListener: () -> Unit = {},
    scheduleListener: () -> Unit = {},
    homeListener: () -> Unit = {},
    worcesterListener: () -> Unit = {},
    franklinListener: () -> Unit = {},
    hampshireListener: () -> Unit = {},
    berkShireListener: () -> Unit = {}
) {
    Scaffold(
        bottomBar = {
            NavBar(
                settingsListener = settingsListener,
                scheduleListener = scheduleListener,
                homeListener = homeListener,
            )
        },
        scaffoldState = rememberScaffoldState(
            rememberDrawerState(
                initialValue = DrawerValue.Closed
            )
        ),
        content = {
            Column(
                modifier = Modifier.fillMaxSize(),
//        modifier = Modifier.fillMaxWidth().absolutePadding(40.dp, 40.dp, 40.dp, 40.dp),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(onClick = worcesterListener,
                    modifier = modifier
                ) {
                    Text(text = "Worcester")
                }

                Button(onClick = franklinListener,
                    modifier = modifier
                ) {
                    Text(text = "Franklin")
                }

                Button(onClick = hampshireListener,
                    modifier = modifier
                ) {
                    Text(text = "Hampshire")
                }

                Button(onClick = berkShireListener,
                    modifier = modifier
                ) {
                    Text(text = "Berkshire")
                }
            }
        },
    )
}
