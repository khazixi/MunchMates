package com.example.myapplication

// Android Imports
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                // Simple Comment Change
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Scaffold(
                        bottomBar = {
                            NavBar(
                                { /* For Settings Function */ },
                                { /* For Schedule Function */ }
                            )
                        },
                        scaffoldState = rememberScaffoldState(
                            rememberDrawerState(
                                initialValue = DrawerValue.Closed
                            )
                        ),
                        content = {
                            HomepageBody(
                                worcesterListener = {},
                                franklinListener = {},
                                hampshireListener = {},
                                berkShireListener = {}
                            )
                        },
            )
        }
            }
        }
    }
}

@Composable
fun NavBar(
    settingsListener: () -> Unit,
    scheduleListener: () -> Unit,
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

    }
}

@Composable
fun HomepageBody(
    worcesterListener: () -> Unit,
    franklinListener: () -> Unit,
    hampshireListener: () -> Unit,
    berkShireListener: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = worcesterListener) {
            Text(text = "Worcester")
        }

        Button(onClick = franklinListener) {
            Text(text = "Franklin")
        }

        Button(onClick = hampshireListener) {
            Text(text = "Hampshire")
        }

        Button(onClick = berkShireListener) {
            Text(text = "Berkshire")
        }
    }
}


@Preview(showBackground = false)
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        NavBar({}, {})
    }
}