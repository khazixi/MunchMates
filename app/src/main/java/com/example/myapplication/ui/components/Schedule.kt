package com.example.myapplication.ui.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ScheduleBody(
    submitListener: () -> Unit = {},
    homeListener: () -> Unit = {},
    settingsListener: () -> Unit = {},
    scheduleListener: () -> Unit = {},
) {
    Scaffold(
        bottomBar = {
            NavBar(
                settingsListener = settingsListener,
                scheduleListener = scheduleListener,
                homeListener = homeListener,
            )
        },
        content = {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
            ) {
                // TODO: Make this so that numbers are the only input and time can be entered easily
                val eventTime = remember {
                    mutableStateOf(TextFieldValue())
                }

                // TODO: Make this more dynamic so multiple invitees can be added
                val invitees = remember {
                    mutableStateOf(TextFieldValue())
                }

                // TODO: Make this a selector
                val diningHall = remember {
                    mutableStateOf(TextFieldValue())
                }

                Text(text = "Schedule an Event")

                TextField(
                    label = {Text(text = "Time")},
                    value = eventTime.value,
                    onValueChange = {eventTime.value = it}
                )

                Spacer(modifier = Modifier.padding(top = 10.dp, bottom = 10.dp))

                TextField(
                    label = {Text(text = "Invitees")},
                    value = invitees.value,
                    onValueChange = {invitees.value = it}
                )

                Spacer(modifier = Modifier.padding(top = 10.dp, bottom = 10.dp))

                TextField(
                    label = {Text(text = "Dining Hall")},
                    value = diningHall.value,
                    onValueChange =  {diningHall.value = it}
                )

                Spacer(modifier = Modifier.padding(top = 10.dp, bottom = 10.dp))

                Box(modifier = Modifier.padding(20.dp, 0.dp, 0.dp, 0.dp)) {
                    Button(
                        onClick = submitListener,
                        shape = RoundedCornerShape(20.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(all = 10.dp)
                            .height(50.dp)
                    ) {
                        Text(text = "Submit")
                    }
                }
            }
        }
    )
}