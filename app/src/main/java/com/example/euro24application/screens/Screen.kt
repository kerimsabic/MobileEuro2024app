package com.example.euro24application.screens

sealed class Screen(val route:String){
    object LoadingScreen: Screen("loading_screen")
    object MainScreen: Screen("main_screen")
    object PlayersScreen: Screen("players_screen")
    object PlayerDetailsScreen: Screen("player_details_screen")
    object RegisterScreen:Screen("register_screen")
    object LogInScreen:Screen("login_screen")

    object TeamScreen:Screen("team_screen")
}
