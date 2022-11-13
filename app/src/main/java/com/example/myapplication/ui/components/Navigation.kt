package com.example.myapplication.ui.components

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import com.example.myapplication.ui.components.HomepageBody
import com.example.myapplication.ui.components.ScheduleBody

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.HomeScreen.route) {
        composable(route = Screen.HomeScreen.route) {
            HomepageBody(
                scheduleListener = {navController.navigate(route = Screen.ScheduleScreen.route)},
                homeListener = {navController.navigate(route = Screen.HomeScreen.route)}
            )
        }
        composable(route = Screen.ScheduleScreen.route) {
            ScheduleBody(
                scheduleListener = {navController.navigate(Screen.ScheduleScreen.route)},
                homeListener = {navController.navigate(route = Screen.HomeScreen.route)}
            )
        }
    }
}

@Composable
fun MainScreen(navController: NavController) {

}