package com.example.myapplication.ui.components

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.HomeScreen.route) {
        composable(route = Screen.HomeScreen.route) {
            HomepageBody(
                scheduleListener = {navController.navigate(route = Screen.ScheduleScreen.route)},
                homeListener = {navController.navigate(route = Screen.HomeScreen.route)},
                settingsListener = {navController.navigate(route = Screen.SettingsScreen.route)}
            )
        }
        composable(route = Screen.ScheduleScreen.route) {
            ScheduleBody(
                scheduleListener = {navController.navigate(Screen.ScheduleScreen.route)},
                homeListener = {navController.navigate(route = Screen.HomeScreen.route)},
                settingsListener = {navController.navigate(route = Screen.SettingsScreen.route)}
            )
        }
        composable(route = Screen.SettingsScreen.route) {
            SettingsBody(
                scheduleListener = {navController.navigate(Screen.ScheduleScreen.route)},
                homeListener = {navController.navigate(route = Screen.HomeScreen.route)},
                settingsListener = {navController.navigate(route = Screen.SettingsScreen.route)}
            )
        }
    }
}