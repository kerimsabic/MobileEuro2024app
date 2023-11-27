package com.example.euro24application


sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: Int
){
    object Home: BottomBarScreen(
        route = "home",
        title = "Home",
        icon = R.drawable.home
    )
    object Matches: BottomBarScreen(
        route = "matches",
        title = "Matches",
        icon = R.drawable.football_field
    )
    object Groups: BottomBarScreen(
        route = "groups",
        title = "Groups",
        icon = R.drawable.groups
    )
    object Profile: BottomBarScreen(
        route = "profile",
        title = "Profile",
        icon = R.drawable.user
    )
}
