package com.example.myapplication.ui.components

sealed class Screen(val route: String) {
    object HomeScreen: Screen(route = "home_screen")
    object ScheduleScreen: Screen(route = "schedule_screen")
    object SettingsScreen: Screen(route = "settings_screen")
}
